package com.tanveershafeeprottoy.chartdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tanveershafeeprottoy.chartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).mainActivity = this
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.activityMainLine -> {
                startActivity(Intent(this, LineChartActivity::class.java))
            }
            R.id.activityMainBar -> {
                startActivity(Intent(this, BarChartActivity::class.java))
            }
            R.id.activityMainPie -> {
                startActivity(Intent(this, PieChartActivity::class.java))
            }
        }
    }
}
