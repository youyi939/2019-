package com.example.youyi.fourteendemo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {
    private BarChart barChart;
    private List<BarEntry> entities;
    private BarDataSet barDataSet;
    private BarData barData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        barChart = view.findViewById(R.id.cj_bar1);
        entities = new ArrayList<>();
        entities.add(new BarEntry(1,75));
        entities.add(new BarEntry(2,80));
        entities.add(new BarEntry(3,81));
        entities.add(new BarEntry(4,80));
        entities.add(new BarEntry(5,79));
        entities.add(new BarEntry(6,78));
        entities.add(new BarEntry(7,83));
        entities.add(new BarEntry(8,85));
        entities.add(new BarEntry(9,83));
        entities.add(new BarEntry(10,80));
        entities.add(new BarEntry(11,84));
        entities.add(new BarEntry(12,83));
        entities.add(new BarEntry(13,82));
        entities.add(new BarEntry(14,85));
        entities.add(new BarEntry(15,90));
        entities.add(new BarEntry(16,87));
        entities.add(new BarEntry(17,85));
        entities.add(new BarEntry(18,81));
        entities.add(new BarEntry(19,78));
        entities.add(new BarEntry(20,75));


        barDataSet = new BarDataSet(entities,"空气质量");
        barData = new BarData(barDataSet);
        barChart.setData(barData);


        return view;
    }

}
