package com.arcfun.library.workmanager.test;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 重复执行的任务上
 */
public class AhsWorkRequest {
    public static final String TAG = "AhsWorkRequest";

    /**
     * 创建重复任务
     *
     * @param workerClass
     * @return
     */
    public static WorkRequest createPeriodicRequest(Class<? extends Worker> workerClass) {
        return getPeriodicWorkRequest(workerClass);
    }


    /**
     * 创建重复任务
     *
     * @param workerClass
     * @return
     */
    public static WorkRequest createRepeatPeriodicRequest(Class<? extends Worker> workerClass, long repeatInterval, TimeUnit repeatIntervalTimeUnit) {
        return getRepeatPeriodicWorkRequest(workerClass, repeatInterval, repeatIntervalTimeUnit);
    }

    public static WorkRequest createOneTimeRequest(Class<? extends Worker> workerClass) {
        return getOneTimeRequest(workerClass);
    }

    /**
     * 创建请求
     *
     * @param workerClass
     * @return
     */
    private static OneTimeWorkRequest getOneTimeRequest(Class<? extends Worker> workerClass) {
        return new OneTimeWorkRequest.Builder(workerClass)
                .setConstraints(defaultConstraints())
                .build();
    }


    /**
     * 创建请求
     *
     * @param workerClass
     * @return
     */
    private static PeriodicWorkRequest getPeriodicWorkRequest(Class<? extends Worker> workerClass) {
        return new PeriodicWorkRequest.Builder(workerClass, 1000 * 60 * 15, TimeUnit.MICROSECONDS)
                .setConstraints(defaultConstraints())
                .build();
    }


    /**
     * 创建定时重复请求
     *
     * @param workerClass
     * @return
     */
    private static PeriodicWorkRequest getRepeatPeriodicWorkRequest(Class<? extends Worker> workerClass, long repeatInterval, TimeUnit repeatIntervalTimeUnit) {
        return new PeriodicWorkRequest.Builder(workerClass, repeatInterval, repeatIntervalTimeUnit)
                .setConstraints(defaultConstraints())
                .build();
    }


    /**
     * 创建配置
     *
     * @return
     */
    private static Constraints defaultConstraints() {
        Log.d(TAG, "defaultConstraints");
        return new Constraints.Builder()
                .build();
    }

    /**
     * @param workerClass worker实现类
     * @param tag         标签
     * @return
     */
    public static OneTimeWorkRequest createOneTimeRequestWithTag(Class<? extends ListenableWorker> workerClass, String tag, @NonNull Map<String, Object> objectMap) {
        Log.d(TAG, "createOneTimeRequestWithTag");
        Data data = new Data.Builder()
                .putAll(objectMap)
                .build();

        return new OneTimeWorkRequest.Builder(workerClass)
                .setInputData(data)
                .setConstraints(defaultConstraints())
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10 * 1000L, TimeUnit.MILLISECONDS)
                .addTag(tag)
                .build();

    }
}
