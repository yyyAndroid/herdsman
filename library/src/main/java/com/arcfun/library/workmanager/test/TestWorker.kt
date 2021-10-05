package com.arcfun.library.workmanager.test

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class TestWorker : Worker {
    private val TAG = "TestWorker"

    constructor(context: Context, workerParameters: WorkerParameters) : super(
        context,
        workerParameters
    ) {
        Log.d(TAG, "TestWorker call  constructor " + workerParameters.id)
    }

    /**
     * 执行内容
     */
    override fun doWork(): Result {
        Log.d(TAG, "TestWorker call  doWork ")
        return Result.retry()
    }
}