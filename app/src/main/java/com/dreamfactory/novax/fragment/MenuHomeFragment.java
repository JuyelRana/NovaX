package com.dreamfactory.novax.fragment;


import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.FragmentHomeMenuPageAdapter;
import com.dreamfactory.novax.model.HomeMenu;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuHomeFragment extends Fragment {

    private MaterialSpinner spinnerMenuHome;
    private GraphView lineChartViewMenuHome;
    private ProgressBar progressBarMenuHome;

    private LinearLayout llReturnVsRiskLayout, llDiversificationLayout, llProfitAndLoss, llCompletedOrder;
    private TextView txtReturnVsRisk, txtDiversification, txtProfitAndLoss, txtCompletedOrder, txtProfitLossCount;

    private RecyclerView recyclerViewMenuHome;
    private FragmentHomeMenuPageAdapter homeMenuPageAdapter;
    private List<HomeMenu> homeMenuList = new ArrayList<>();

    //Handle ProgressBar
    private int progress = 0;
    private Handler handler = new Handler();


    public MenuHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_home, container, false);

        spinnerMenuHome = view.findViewById(R.id.spinner_menu_home);
        lineChartViewMenuHome = view.findViewById(R.id.lineChartViewMenuHome);
        progressBarMenuHome = view.findViewById(R.id.progressBarMenuHome);

        llReturnVsRiskLayout = view.findViewById(R.id.llReturnVsRiskLayout);
        llDiversificationLayout = view.findViewById(R.id.llDiversificationLayout);
        txtReturnVsRisk = view.findViewById(R.id.txtReturnVsRisk);
        txtDiversification = view.findViewById(R.id.txtDiversification);

        llProfitAndLoss = view.findViewById(R.id.llProfitAndLoss);
        llCompletedOrder = view.findViewById(R.id.llCompletedOrder);
        txtCompletedOrder = view.findViewById(R.id.txtCompletedOrder);
        txtProfitAndLoss = view.findViewById(R.id.txtProfitAndLoss);

        txtProfitLossCount = view.findViewById(R.id.txtProfitLossCount);

        recyclerViewMenuHome = view.findViewById(R.id.recyclerViewMenuHome);
        recyclerViewMenuHome.setHasFixedSize(false);
        recyclerViewMenuHome.setLayoutManager(new LinearLayoutManager(getContext()));


        implementationSpinnerMenuHome();
        implementationLineChartViewMenuHome();
        implementationProgressBarMenuHome();

        //implementationSeekBarMenuHome();

        implementationllReturnVsRiskLayout();
        implementationllDiversificationLayout();

        implementationllProfitAndLossLayout();
        implementationllCompletedOrderLayout();

        implementationRecyclerViewMenuHome();

        firstCall();


        return view;
    }

    private void firstCall() {
        llReturnVsRiskLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
        txtReturnVsRisk.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

        llDiversificationLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
        txtDiversification.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

        llCompletedOrder.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_sharpe));
        txtCompletedOrder.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));

        llProfitAndLoss.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_shape_white));
        txtProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

    }

    private void implementationProgressBarMenuHome() {

        //progress = progressBarMenuHome.getProgress();

        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarMenuHome.setProgress(progress);
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void implementationRecyclerViewMenuHome() {
        homeMenuList.clear();
        homeMenuList.add(new HomeMenu(R.drawable.icon_nvedia, "US:NVIDIA", "40+(1.5%)"));
        homeMenuList.add(new HomeMenu(R.drawable.icon_facebook, "US:AMD", "40+(1.5%)"));
        homeMenuPageAdapter = new FragmentHomeMenuPageAdapter(homeMenuList, getContext());
        recyclerViewMenuHome.setAdapter(homeMenuPageAdapter);
    }

    private void implementationllCompletedOrderLayout() {
        llCompletedOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llProfitAndLoss.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_shape_white));
                txtProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                llCompletedOrder.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_sharpe));
                txtCompletedOrder.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });
    }

    private void implementationllProfitAndLossLayout() {
        llProfitAndLoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCompletedOrder.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
                txtCompletedOrder.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                llProfitAndLoss.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));
                txtProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });
    }

    private void implementationllDiversificationLayout() {
        llDiversificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDiversification.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                llDiversificationLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_sharpe));

                txtReturnVsRisk.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                llReturnVsRiskLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_shape_white));

                implementationProgressBarMenuHome();
            }
        });
    }

    private void implementationllReturnVsRiskLayout() {
        llReturnVsRiskLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDiversification.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                llDiversificationLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));

                txtReturnVsRisk.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                llReturnVsRiskLayout.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_convertlayout_rounded_sharpe));

                implementationProgressBarMenuHome();
            }
        });
    }

    private void implementationLineChartViewMenuHome() {
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
        // series.setColor(R.color.colorPrimary);
        series.setThickness(6);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.parseColor("#24A2C1"));
        // series.setBackgroundColor(R.color.colorPrimaryDark);
        series.setAnimated(true);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(8);

        lineChartViewMenuHome.addSeries(series);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(lineChartViewMenuHome);
        staticLabelsFormatter.setHorizontalLabels(months);
        lineChartViewMenuHome.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        lineChartViewMenuHome.getGridLabelRenderer().setVerticalLabelsVisible(false);

        lineChartViewMenuHome.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);  //For invisible x and y axies line
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

    private void implementationSpinnerMenuHome() {

        spinnerMenuHome.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.right_convertlayout_rounded_shape_white));
        spinnerMenuHome.setItems("2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020");
        spinnerMenuHome.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();

                implementationLineChartViewMenuHome();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

    public int getProgressData() {
        return new Random().nextInt(100) + 1;
    }
}

