package com.arcfun.library.workmanager.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class AhsWorkManager {

    private static final String TAG = "AhsWorkManager";
    private static AhsWorkManager sInstance;

    public static boolean init = false;

    public WorkManager sWorkManager;

    private Context mContext;

    private AhsWorkManager() {
    }

    public static AhsWorkManager getInstance() {
        if (sInstance == null) {
            synchronized (AhsWorkManager.class) {
                if (sInstance == null) {
                    sInstance = new AhsWorkManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        WorkManager.initialize(context, new Configuration.Builder().build());
        sWorkManager = WorkManager.getInstance();
    }


    /**
     * 执行人脸log上传重复任务
     */
    public void applyPeriodicWork(String name, Class<? extends Worker> workerClass) {
        sWorkManager.enqueueUniquePeriodicWork(name, ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) AhsWorkRequest.createPeriodicRequest(workerClass));
    }


    /**
     * 执行重复任务
     */
    public void applyRepeatPeriodicWork(String name, Class<? extends Worker> workerClass, long repeatInterval, TimeUnit repeatIntervalTimeUnit) {
        sWorkManager.enqueueUniquePeriodicWork(name, ExistingPeriodicWorkPolicy.REPLACE,
                (PeriodicWorkRequest) AhsWorkRequest.createRepeatPeriodicRequest(workerClass, repeatInterval, repeatIntervalTimeUnit));
    }

    /**
     * 执行一次的worker
     *
     * @param workerClass
     */
    public void applyOneTimeWork(Class<? extends Worker> workerClass) {
        sWorkManager.enqueue(AhsWorkRequest.createOneTimeRequest(workerClass));
    }

    /**
     * 执行一次任务
     *
     * @param workerClass
     * @param tag         标签
     * @param objectMap   传值
     */

    @SuppressLint("RestrictedApi")
    public void applyOneTimeWork(Class<? extends ListenableWorker> workerClass, String tag, Map<String, Object> objectMap) {

        Log.e(TAG, "AhsWorkManager applyOneTimeWork " + objectMap.toString());

        final OneTimeWorkRequest request = AhsWorkRequest.createOneTimeRequestWithTag(workerClass, tag, objectMap);

        final Operation operation = sWorkManager.enqueue(request);

        printWorkInfo(request.getId());



    }

    public void printWorkInfo(String tag){
        try {
            List<WorkInfo> ws = sWorkManager.getWorkInfosByTag(tag).get();

            for (int i = 0; i < ws.size(); i++) {
                Log.d(TAG, ws.get(i).toString());
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printWorkInfo(UUID workUUID) {
        try {
            Log.e(TAG, "AhsWorkManager UUID = " + workUUID.toString());

            WorkInfo workInfo = sWorkManager.getWorkInfoById(workUUID).get();

            Log.e(TAG, "AhsWorkManager WorkInfo" + workInfo.toString());
            Log.e(TAG, "AhsWorkManager valueMap" + workInfo.toString());

        } catch (ExecutionException e) {
            Log.e(TAG, "AhsWorkManager ExecutionException = " + e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            Log.e(TAG, "AhsWorkManager InterruptedException = " + e.toString());
            e.printStackTrace();
        } catch (Exception e) {
            Log.e(TAG, "AhsWorkManager Exception = " + e.toString());
        }

    }

    /**
     * 取消所有任务
     */
    public void cancelAllWorker() {
        sWorkManager.cancelAllWork();
    }

    public void cancelWorkTag(String tag) {
        sWorkManager.cancelAllWorkByTag(tag);
    }

    /**
     * 会清楚数据库左右成功的任务
     */
    public void release() {
        sWorkManager.pruneWork();
    }
}
