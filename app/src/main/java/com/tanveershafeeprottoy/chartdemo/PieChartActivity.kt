package com.tanveershafeeprottoy.chartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.tanveershafeeprottoy.chartdemo.databinding.ActivityPieChartBinding

class PieChartActivity : AppCompatActivity() {
    lateinit var activityPieChartBinding: ActivityPieChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPieChartBinding = DataBindingUtil.setContentView(this, R.layout.activity_pie_chart)
        setupPieChart()
    }

    private fun setupPieChart() {
        val entries = mutableListOf<PieEntry>()

        entries.add(PieEntry(18.5f, "Green"))
        entries.add(PieEntry(26.7f, "Yellow"))
        entries.add(PieEntry(24.0f, "Red"))
        entries.add(PieEntry(30.8f, "Blue"))

        val set = PieDataSet(entries, "Election Results")
        val data = PieData(set)
        activityPieChartBinding.activityPieChartMain.setData(data)
        activityPieChartBinding.activityPieChartMain.invalidate()
    }
}
