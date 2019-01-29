package com.tanveershafeeprottoy.chartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.tanveershafeeprottoy.chartdemo.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {
    val entries: MutableList<BarEntry> = mutableListOf()
    lateinit var activityBarChartBinding: ActivityBarChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBarChartBinding = DataBindingUtil.setContentView(this, R.layout.activity_bar_chart)
        setupBarChart()
    }

    private fun setupBarChart() {
        val entries = mutableListOf<BarEntry>()
        entries.add(BarEntry(0f, 30f))
        entries.add(BarEntry(1f, 80f))
        entries.add(BarEntry(2f, 60f))
        entries.add(BarEntry(3f, 50f))
        // gap of 2f
        entries.add(BarEntry(5f, 70f))
        entries.add(BarEntry(6f, 60f))

        val set = BarDataSet(entries, "BarDataSet")

        val data = BarData(set)
        //data.setBarWidth(0.9f) // set custom bar width
        activityBarChartBinding.activityBarChartMain.data = data
        activityBarChartBinding.activityBarChartMain.setFitBars(true) // make the x-axis fit exactly all bars
        activityBarChartBinding.activityBarChartMain.invalidate()
    }
}
