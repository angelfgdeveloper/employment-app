package com.angelfgdeveloper.manresapp.ui.statistics;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.databinding.FragmentStatisticsBinding;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.LegendModel;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.util.ArrayList;
import java.util.List;

import io.github.florent37.shapeofview.shapes.CircleView;

public class StatisticsFragment extends Fragment {

    private FragmentStatisticsBinding binding;
    private Toolbar toolbar;
    private PieChart pieChart;
    private ValueLineChart valueLineChart;
    private BarChart barChart;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStatisticsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        toolbar = binding.toolbar;
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Estadisticas empresariales");
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).popBackStack();
        });

        pieChart = binding.piechart;
        valueLineChart = binding.valueLineChart;
        barChart = binding.barChart;

        piecChartView();
        valueLineChartView();
        barChartView();

        return root;
    }

    private void piecChartView() {
        pieChart.addPieSlice(
                new PieModel(
                        "Responsabilidad",
                        Integer.parseInt("23"),
                        Color.parseColor("#FFA000")));
        pieChart.addPieSlice(
                new PieModel(
                        "Rendimiento",
                        Integer.parseInt("15"),
                        Color.parseColor("#E91E63")));
        pieChart.addPieSlice(
                new PieModel(
                        "Innovación",
                        Integer.parseInt("45"),
                        Color.parseColor("#F44336")));
        pieChart.addPieSlice(
                new PieModel(
                        "Crecimiento",
                        Integer.parseInt("17"),
                        Color.parseColor("#7B1FA2")));

        pieChart.startAnimation();
    }

    private void valueLineChartView() {
        ValueLineSeries series = new ValueLineSeries();
        series.setColor(Color.parseColor("#FFA000"));
        series.addPoint(new ValueLinePoint("Honestidad", 3.0f));
        series.addPoint(new ValueLinePoint("Interacción", 5.0f));
        series.addPoint(new ValueLinePoint("Iniciativa", 0.8f));
        series.addPoint(new ValueLinePoint("Popularidad", 2.6f));
        series.addPoint(new ValueLinePoint("Rentabilidad", 3.7f));
        valueLineChart.addSeries(series);
        valueLineChart.startAnimation();
    }

    private void barChartView() {
        barChart.addBar(new BarModel("Antiguedad",2.3f, 0xFF123456));
        barChart.addBar(new BarModel("Sueldo",2.f,  0xFF343456));
        barChart.addBar(new BarModel("Aguinaldo",3.3f, 0xFF563456));
        barChart.addBar(new BarModel("Vacaciones",1.1f, 0xFF873F56));

        barChart.startAnimation();

    }
}