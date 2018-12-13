package com.desktop.myapplication

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

/**
 * Created by HashInclude on 13-12-2018
 * Copyright © 2018 HashInclude IO
 */
class SampleJobService : JobService(), JobAsyncTask.JobAsyncTaskListener {
    override fun onTaskFinished(params: JobParameters?) {
        jobFinished(params, false)
        Log.d("SampleJobService", "onTaskFinished() ${params?.jobId}")
    }

    override fun onTaskFailed(params: JobParameters?) {
        jobFinished(params, false)
        Log.d("SampleJobService", "onTaskFailed() ${params?.jobId}")
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("SampleJobService", "onStopJob() ${params?.jobId}")
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        JobAsyncTask(params, this).execute()
        return true
    }


}