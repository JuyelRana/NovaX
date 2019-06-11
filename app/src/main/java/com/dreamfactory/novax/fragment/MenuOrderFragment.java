package com.dreamfactory.novax.fragment;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.activity.BuyMarketOrder;
import com.dreamfactory.novax.activity.SellMktOrder;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuOrderFragment extends Fragment {

    private MaterialSpinner spinnerMenuOrder;
    private GraphView lineChartViewMenuOrder;

    private Button btnSellMenuOrder, btnBuyMenuOrder;


    public MenuOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_order, container, false);

        spinnerMenuOrder = view.findViewById(R.id.spinner_menu_order);
        lineChartViewMenuOrder = view.findViewById(R.id.lineChartViewMenuOrder);
        btnBuyMenuOrder = view.findViewById(R.id.btnBuyMenuOrder);
        btnSellMenuOrder = view.findViewById(R.id.btnSellMenuOrder);

        implementationSpinnerMenuOrder();
        implementationLineChartViewMenuOrder();

        btnSellMenuOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SellMktOrder.class);
                startActivity(intent);
            }
        });

        btnBuyMenuOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BuyMarketOrder.class));
            }
        });


        return view;
    }

    private void implementationLineChartViewMenuOrder() {

        DataPoint[] dp = null;
        String[] months = null;

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            dp = getDataPoint();
            months = new String[]{"Jan", "Mar", "May", "Jul", "Sep", "Nov"};
        } else {
            dp = getDataPointTwelve();
            months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dp);

        series.setColor(Color.rgb(32, 141, 168));
        series.setThickness(6);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.parseColor("#24A2C1"));
        series.setAnimated(true);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(8);

        lineChartViewMenuOrder.addSeries(series);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(lineChartViewMenuOrder);
        staticLabelsFormatter.setHorizontalLabels(months);
        lineChartViewMenuOrder.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        lineChartViewMenuOrder.getGridLabelRenderer().setVerticalLabelsVisible(false);

        lineChartViewMenuOrder.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);  //For invisible x and y axies line
    }

    private DataPoint[] getDataPointTwelve() {
        DataPoint[] dp = new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 7),
                new DataPoint(4, 2),
                new DataPoint(5, 5),
                new DataPoint(6, 7),
                new DataPoint(7, 2),
                new DataPoint(8, 6),
                new DataPoint(9, 8),
                new DataPoint(10, 2),
                new DataPoint(11, 1),
        };

        return (dp);
    }

    private DataPoint[] getDataPoint() {
        DataPoint[] dp = new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 7),
                new DataPoint(4, 2),
                new DataPoint(5, 5),
        };

        return (dp);
    }


    private void implementationSpinnerMenuOrder() {
        spinnerMenuOrder.setItems("1 Year", "2 Year", "3 Year", "4 Year", "5 Year", "6 Year", "7 Year", "8 Year", "9 Year", "10 Year");
        spinnerMenuOrder.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                implementationLineChartViewMenuOrder();  //for change the line chart value

                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

}
