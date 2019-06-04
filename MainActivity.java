package com.example.youyi.fourteendemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart lineChart;
    private List<Entry> entries;
    private List<Entry> entries2;
    private LineDataSet lineDataSet;
    private LineDataSet lineDataSet2;
    private LineData lineData;
    private List<ILineDataSet> dataSets;
    private List<String> names;
    private ViewPager viewPager;
    private List<Fragment>fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = findViewById(R.id.cj_line);
        viewPager = findViewById(R.id.cj_viewpager);
        entries = new ArrayList<>();
        entries2 = new ArrayList<>();
        dataSets = new ArrayList<>();
        names = new ArrayList<>();
        lineChart.setEnabled(true);

        names.add("昨天");
        names.add("今天");
        names.add("明天");
        names.add("周五");
        names.add("周六");
        names.add("周日");

        entries.add(new BarEntry(2,22));
        entries.add(new BarEntry(3,24));
        entries.add(new BarEntry(4,25));
        entries.add(new BarEntry(5,25));
        entries.add(new BarEntry(6,25));
        entries.add(new BarEntry(7,22));


        entries2.add(new BarEntry(2,14));
        entries2.add(new BarEntry(3,15));
        entries2.add(new BarEntry(4,16));
        entries2.add(new BarEntry(5,17));
        entries2.add(new BarEntry(6,16));
        entries2.add(new BarEntry(7,16));


        lineDataSet = new LineDataSet(entries,"温度");
        lineDataSet2 = new LineDataSet(entries2,"温度");
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet2.setColors(ColorTemplate.JOYFUL_COLORS);
        lineChart.getAxisRight().setEnabled(false);


        dataSets.add(lineDataSet);
        dataSets.add(lineDataSet2);
        lineData = new LineData(dataSets);
        lineChart.setData(lineData);

        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(adapter);

    }
}
