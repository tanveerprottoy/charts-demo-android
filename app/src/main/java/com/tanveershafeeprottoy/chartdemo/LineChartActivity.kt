package com.tanveershafeeprottoy.chartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.tanveershafeeprottoy.chartdemo.databinding.ActivityLineChartBinding

class LineChartActivity : AppCompatActivity() {
    val quarters = arrayOf("Q1", "Q2", "Q3", "Q4")
    lateinit var activityLineChartBinding: ActivityLineChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLineChartBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_line_chart)
        setupLineChart()
    }

    private fun setupLineChart() {
        val valsComp1 = ArrayList<Entry>()
        val valsComp2 = ArrayList<Entry>()
        val c1e1 = Entry(0f, 100000f) // 0 == quarter 1
        valsComp1.add(c1e1)
        val c1e2 = Entry(1f, 140000f) // 1 == quarter 2 ...
        valsComp1.add(c1e2)

        val c2e1 = Entry(0f, 130000f) // 0 == quarter 1
        valsComp2.add(c2e1)
        val c2e2 = Entry(1f, 115000f) // 1 == quarter 2 ...
        valsComp2.add(c2e2)

        val setComp1 = LineDataSet(valsComp1, "Company 1")
        setComp1.axisDependency = AxisDependency.LEFT
        val setComp2 = LineDataSet(valsComp2, "Company 2")
        setComp2.axisDependency = AxisDependency.LEFT

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(setComp1)
        dataSets.add(setComp2)

        val data = LineData(dataSets)

        val xAxis = activityLineChartBinding.activityLineChartMain.getXAxis()
        xAxis.setGranularity(1f)
        xAxis.setValueFormatter(axisValueFormatter)

        activityLineChartBinding.activityLineChartMain.data = data
        activityLineChartBinding.activityLineChartMain.invalidate()
    }

    val axisValueFormatter = IAxisValueFormatter { value, axis ->
        quarters[value.toInt()]
    }


}
