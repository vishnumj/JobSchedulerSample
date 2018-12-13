package com.desktop.myapplication

import android.app.job.JobParameters
import android.os.AsyncTask
import android.util.Log

class JobAsyncTask(var params: JobParameters?, var mJobAsyncTaskListener: JobAsyncTaskListener?) :
    AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg params: Unit?) {
        Log.d("JobAsyncTask", "doInBackground() started")
        Thread.sleep(5000)
        Log.d("JobAsyncTask", "doInBackground() finised")
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        Log.d("JobAsyncTask", "onPostExecute() called")
        mJobAsyncTaskListener?.onTaskFinished(params)
    }

    interface JobAsyncTaskListener {
        fun onTaskFinished(params: JobParameters?)
        fun onTaskFailed(params: JobParameters?)
    }
}