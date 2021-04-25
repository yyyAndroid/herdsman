package com.arcfun.afl

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.view.View
import java.io.FileNotFoundException
import java.io.IOException
import java.io.RandomAccessFile
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

/**
 * 设备相关帮助类
 *
 * @author RobinVanYang created at 2017-6-19.
 */
class DeviceUtils {
    /**
     * 判断WIFI网络是否可用的方法
     *
     * @return wifi network state.
     */
    @SuppressLint("MissingPermission")
    fun isWifiNetworkConnected(context: Context): Boolean {
        val connManager = context.applicationContext
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifiNetworkInfo =
            connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        return null != wifiNetworkInfo && wifiNetworkInfo.isConnected
    }

    companion object {
        private const val TAG = "DeviceUtils"
        const val ANDROID_SYSTEM_ICCID = "android_system_iccid"
        const val ANDROID_SYSTEM_ICCID_TIME = "android_system_iccid_time"
        private const val COMMAND_AIRPLANE_ON =
            "settings put global airplane_mode_on 1 \n " +
                    "am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true\n "
        private const val COMMAND_AIRPLANE_OFF =
            "settings put global airplane_mode_on 0 \n" +
                    " am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false\n "
        private const val COMMAND_SU = "su"

        /**
         * Get IP address from first non-localhost interface
         *
         * @param useIPv4 true=return ipv4, false=return ipv6
         * @return address or empty string
         */
        fun getIPAddress(useIPv4: Context): String {
            try {
                val interfaces: List<NetworkInterface> =
                    Collections.list(NetworkInterface.getNetworkInterfaces())
                for (intf in interfaces) {
                    val addrs: List<InetAddress> =
                        Collections.list(intf.inetAddresses)
                    for (addr in addrs) {
                        if (!addr.isLoopbackAddress) {
                            val sAddr = addr.hostAddress
                            //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                            val isIPv4 = sAddr.indexOf(':') < 0
                            if (useIPv4 != null) {
                                if (isIPv4) return sAddr
                            } else {
                                if (!isIPv4) {
                                    val delim = sAddr.indexOf('%') // drop ip6 zone suffix
                                    return if (delim < 0) sAddr.toUpperCase() else sAddr.substring(
                                        0,
                                        delim
                                    ).toUpperCase()
                                }
                            }
                        }
                    }
                }
            } catch (ex: Exception) {
            } // for now eat exceptions
            return ""
        }

        fun Send(file: String?, cmd: String) {
            var localRandomAccessFile: RandomAccessFile? = null
            try {
                localRandomAccessFile = RandomAccessFile(file, "rw")
                localRandomAccessFile.writeBytes(
                    """
    $cmd

    """.trimIndent()
                )
                localRandomAccessFile.close()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        /**
         * check if device network is fully usable.
         *
         * @param context
         * @return
         */
        @SuppressLint("MissingPermission")
        fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return null != activeNetworkInfo && activeNetworkInfo.isConnected
        }

        /**
         * 获取设备唯一标识符
         *
         * @param context Application级别上下文
         * @return
         */
        fun getDeviceId(context: Context): String {
            var androidId = ""
            val contentResolver =
                context.applicationContext.contentResolver
            if (contentResolver != null) {
                androidId = Settings.Secure.getString(
                    contentResolver,
                    Settings.Secure.ANDROID_ID
                )
            }
            return androidId
        }

        /**
         * 获取设备的deviceId
         */
        @SuppressLint("MissingPermission")
        fun getImei(context: Context): String? {
            val TelephonyMgr = context.applicationContext
                .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            var imei: String? = null
            if (TelephonyMgr != null) {
                imei = TelephonyMgr.deviceId

                //兼容交易柜rom. 交易柜rom返回的imei串格式为 IMEI: <real value>
                if (!TextUtils.isEmpty(imei) && imei.contains("IMEI: ")) {
                    val imeiArray = imei.split(": ").toTypedArray()
                    if (imeiArray.size > 1) {
                        imei = imeiArray[1]
                    }
                }
            }
            return imei
        }

        /**
         * hides both the navigation bar and the status bar
         *
         * @param activity where is the current view belongs to.
         * @see [Hiding the Navigation Bar](https://developer.android.com/training/system-ui/navigation.html)
         */
        fun hideVirtualBar(activity: Activity) {
            val decorView = activity.window.decorView
            val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
            decorView.systemUiVisibility = uiOptions
        }

        /**
         * 获取设备型号
         *
         * 如 MI2SC
         *
         * @return 设备型号
         */
        val model: String
            get() {
                var model = Build.MODEL
                model = model?.trim { it <= ' ' }?.replace("\\s*".toRegex(), "") ?: ""
                return model
            }
    }

    fun getIP(context: Context?): String? {
        try {
            val en = NetworkInterface.getNetworkInterfaces()
            while (en.hasMoreElements()) {
                val intf = en.nextElement()
                val enumIpAddr = intf.inetAddresses
                while (enumIpAddr.hasMoreElements()) {
                    val inetAddress = enumIpAddr.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return inetAddress.hostAddress.toString()
                    }
                }
            }
        } catch (ex: SocketException) {
            ex.printStackTrace()
        }
        return null
    }
}