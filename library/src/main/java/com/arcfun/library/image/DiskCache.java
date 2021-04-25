package com.arcfun.library.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class DiskCache implements ICache {
    static String cacheDir = "sdcard/cache/";

    /**
     * 从文件中获取
     *
     * @param url
     * @return
     */
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    /**
     * 写入到文件
     *
     * @param url
     * @param bitmap
     */
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
