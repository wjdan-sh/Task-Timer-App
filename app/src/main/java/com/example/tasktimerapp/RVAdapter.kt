package com.example.tasktimerapp


import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class RVAdapter (private val Fragment: ViewTaskFragment ): RecyclerView.Adapter<RVAdapter.MessageViewHolder>() {
    private var taskList: List<Tasks> = listOf()
    var Timer = Timer()
    private val mInterval = Constants.TIMER_INTERVAL
    private var mHandler: Handler? = null

    private var timeInSeconds = 0L
    private var startButtonClicked = false



    class MessageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.MessageViewHolder {
        return RVAdapter.MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_task,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.MessageViewHolder, position: Int) {
        val aTask = taskList[position]

        holder.itemView.apply {
            tvTitle.text = aTask.task
            time.text =aTask.time
            var timee = " "
            tvDescription.text = aTask.description

            if(aTask.time != "00:00:00") {
                llitem.setBackgroundColor(Color.parseColor("#A3E9F1F1"))
            }

            var run =false


                fun updateStopWatchView(timeInSeconds: Long) {
                    val formattedTime = Utility.getFormattedStopWatch((timeInSeconds * 1000))
                    time.text = formattedTime
                }
                var mStatusChecker: Runnable = object : Runnable {

                    override fun run() {
                        try {
                            timeInSeconds += 1
                            updateStopWatchView(timeInSeconds)
                        } finally {
                            mHandler!!.postDelayed(this, mInterval.toLong())
                        }
                    }
                }
                fun startOrStopButtonClicked() {
                    if (!startButtonClicked) {
                        run=true
                        mHandler = Handler(Looper.getMainLooper())
                        mStatusChecker.run()
                        startButtonClicked = !startButtonClicked

                    } else {
                        mHandler?.removeCallbacks(mStatusChecker)
                        startButtonClicked = !startButtonClicked
                        timee = time.text.toString()
                        time.text = timee
                        timeInSeconds = 0L

                        Fragment.updateTaskTime(aTask,timee)
                    }
                }

            time.setOnClickListener {
            if(aTask.time == "00:00:00") {
                startOrStopButtonClicked()
            }else {
                time.text =aTask.time
            }

            }
            delete.setOnClickListener {
                Fragment.deleteTask(aTask)
            }

        }
    }

    override fun getItemCount() = taskList.size

    fun rvChange(tasks: List<Tasks>){
        this.taskList = tasks
        notifyDataSetChanged()
    }


}

