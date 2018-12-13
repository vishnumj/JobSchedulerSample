package com.desktop.myapplication

import android.app.job.JobScheduler
import android.support.v4.content.ContextCompat.getSystemService
import android.app.job.JobInfo
import android.content.ComponentName
import android.content.Context
import android.util.Log


/**
 * Created by HashInclude on 13-12-2018
 * Copyright © 2018 HashInclude IO
 */
class JobUtils {

    companion object {
        var mInstance: JobUtils? = null
        fun getInstance(): JobUtils? {
            return if (mInstance == null) {
                mInstance = JobUtils()
                return mInstance
            } else mInstance
        }
    }

    fun scheduleJob(mContext: Context, LOAD_ARTWORK_JOB_ID: Int) {
        val jobScheduler: JobScheduler? = mContext.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler?.schedule(
            JobInfo.Builder(
                LOAD_ARTWORK_JOB_ID,
                ComponentName(mContext, SampleJobService::class.java)
            ).setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY).build()
        )
        Log.d("scheduleJob()", "${LOAD_ARTWORK_JOB_ID} scheduleJob called")
    }
}