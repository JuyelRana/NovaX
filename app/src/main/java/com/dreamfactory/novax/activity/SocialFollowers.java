package com.dreamfactory.novax.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.SocialFollowersAdapter;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.model.Watchlist;
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
import lecho.lib.hellocharts.view.LineChartView;

public class SocialFollowers extends AppCompatActivity {

    private Toolbar toolBarSoicalFollowers;

    private MaterialSpinner spinnerYearSocialFollowers;
    private GraphView lineSocialFollowers;
    private LinearLayout llCurrentTradesTab, llTradesReviewTab;
    private TextView txtCurrentTradesTab, txtTraderReviewsTab;
    private RecyclerView recyclerViewSocialFollowers;
    List<Watchlist> socialFollowersList = new ArrayList<>();
    private SocialFollowersAdapter socialFollowersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_followes);

        toolBarSoicalFollowers = findViewById(R.id.toolBarSoicalFollowers);
        recyclerViewSocialFollowers = findViewById(R.id.recyclerViewSocialFollowers);
        toolBarSoicalFollowers.setTitle("Social Followers");
        setSupportActionBar(toolBarSoicalFollowers);

        lineSocialFollowers = findViewById(R.id.lineSocialFollowers);
        spinnerYearSocialFollowers = findViewById(R.id.spinnerYearSocialFollowers);
        llCurrentTradesTab = findViewById(R.id.llCurrentTradesTab);
        llTradesReviewTab = findViewById(R.id.llTradesReviewTab);
        txtCurrentTradesTab = findViewById(R.id.txtCurrentTradesTab);
        txtTraderReviewsTab = findViewById(R.id.txtTraderReviewsTab);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        implementationSpinnerYearSocialFollowers();
        implementationLineSocialFollowers();
        implementationllCurrentTradesTab();
        implementationllTradesReviewTab();
        implementationRecycler();

        firstCall();
    }

    private void implementationRecycler() {
        recyclerViewSocialFollowers.setHasFixedSize(false);
        recyclerViewSocialFollowers.setLayoutManager(new LinearLayoutManager(this));

        socialFollowersList.clear();
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));

        socialFollowersAdapter = new SocialFollowersAdapter(socialFollowersList, this);
        recyclerViewSocialFollowers.setAdapter(socialFollowersAdapter);

    }

    private void firstCall() {
        llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_sharpe));
        txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_shape_white));
        txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

    }

    private void implementationllTradesReviewTab() {
        llTradesReviewTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_sharpe));
                txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_shape_white));
                txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            }
        });
    }

    private void implementationllCurrentTradesTab() {
        llCurrentTradesTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_sharpe));
                txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_shape_white));
                txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));



            }
        });
    }

    private void implementationLineSocialFollowers() {
        DataPoint[] dp = null;
        String[] months = null;

        if (SocialFollowers.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
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

        lineSocialFollowers.addSeries(series);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(lineSocialFollowers);
        staticLabelsFormatter.setHorizontalLabels(months);
        lineSocialFollowers.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        lineSocialFollowers.getGridLabelRenderer().setVerticalLabelsVisible(false);

        lineSocialFollowers.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);  //For invisible x and y axies line
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

    private void implementationSpinnerYearSocialFollowers() {
        spinnerYearSocialFollowers.setItems("1 Year", "2 Year", "3 Year", "4 Year", "5 Year", "6 Year", "7 Year", "8 Year", "9 Year", "10 Year");
        spinnerYearSocialFollowers.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                implementationLineSocialFollowers();  //for change the line chart value

                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
