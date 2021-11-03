package com.example.tasktimerapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tasktimerapp.Constants.TIMER_INTERVAL
import com.example.tasktimerapp.R
import com.example.tasktimerapp.Utility.getFormattedStopWatch
import com.example.tasktimerapp.databinding.ActivityMainBinding

class Timer : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private val mInterval = TIMER_INTERVAL
    private var mHandler: Handler? = null

    private var timeInSeconds = 0L
    private var startButtonClicked = false

    lateinit var textView:TextView

    fun startOrStopButtonClicked(textView: TextView) {
        if (!startButtonClicked) {
            startTimer()
            startTimerView(textView)
        } else {
            stopTimer()
            stopTimerView(textView)
        }

    }

    private fun stopTimerView(textView: TextView) {
       textView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.teal_700
            )
        )
//        textView.setText(R.string.resume)
        startButtonClicked = false
    }

    private fun startTimerView(textView: TextView) {

        textView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.red
            )
        )
        //binding?.startOrStopTextView?.setText(R.string.stop)
        startButtonClicked = true

    }

    private fun startTimer() {
        mHandler = Handler(Looper.getMainLooper())
        mStatusChecker.run()
    }

    private fun stopTimer() {
        mHandler?.removeCallbacks(mStatusChecker)
    }

    private var mStatusChecker: Runnable = object : Runnable {
        override fun run() {
            try {
                timeInSeconds += 1
//                Log.e("timeInSeconds", timeInSeconds.toString())
                updateStopWatchView(timeInSeconds)
            } finally {
                mHandler!!.postDelayed(this, mInterval.toLong())
            }
        }
    }

    private fun updateStopWatchView(timeInSeconds: Long) {
        val formattedTime = getFormattedStopWatch((timeInSeconds * 1000))
//        Log.e("formattedTime", formattedTime)
        textView.text = formattedTime +""
    }

    override fun onDestroy() {
        super.onDestroy()
        stopTimer()
    }

}


