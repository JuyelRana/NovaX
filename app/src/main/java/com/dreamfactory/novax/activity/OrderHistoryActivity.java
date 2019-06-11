package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.graphics.Color;
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

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.OderHistoryAdapter;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.model.OrderHistoryList;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity {
    private Toolbar toolBarAmendOrder;
    private RecyclerView recyclerOrderHistory;
    List<OrderHistoryList> orderHistoryLists = new ArrayList<>();
    private OderHistoryAdapter oderHistoryAdapter;
    private LinearLayout historicalOrderHistoryLayout, completedOrderHistoryLayout, activeOrderHistoryLayout;
    private TextView txtActiveOrderHistory, txtCompleteOrderHistory, txtHistoricalOrderHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        toolBarAmendOrder = findViewById(R.id.toolbar_order_history);
        toolBarAmendOrder.setTitle("Orders History");
        setSupportActionBar(toolBarAmendOrder);

        recyclerOrderHistory = findViewById(R.id.recyclerOrderHistory);
        recyclerOrderHistory.setHasFixedSize(false);
        recyclerOrderHistory.setLayoutManager(new LinearLayoutManager(this));

        orderHistoryLists.clear();
        orderHistoryLists.add(new OrderHistoryList("US: NVIDIA", "Yesterday, 515 AM", "Sell", "Limit Order", "1,500", "USD 1.75", "Dec 12, 2018", ""));
        orderHistoryLists.add(new OrderHistoryList("US: FTFT", "Yesterday, 515 AM", "Sell", "Limit Order", "1,500", "USD 1.75", "Dec 12, 2018", "1"));
        orderHistoryLists.add(new OrderHistoryList("US: FTFT", "Yesterday, 515 AM", "Sell", "Limit Order", "1,500", "USD 1.75", "Dec 12, 2018", ""));
        oderHistoryAdapter = new OderHistoryAdapter(orderHistoryLists, this);
        recyclerOrderHistory.setAdapter(oderHistoryAdapter);

        historicalOrderHistoryLayout = findViewById(R.id.historicalOrderHistoryLayout);
        completedOrderHistoryLayout = findViewById(R.id.completedOrderHistoryLayout);
        activeOrderHistoryLayout = findViewById(R.id.activeOrderHistoryLayout);
        txtActiveOrderHistory = findViewById(R.id.txtActiveOrderHistory);
        txtCompleteOrderHistory = findViewById(R.id.txtCompleteOrderHistory);
        txtHistoricalOrderHistory = findViewById(R.id.txtHistoricalOrderHistory);


        historicalOrderHistoryLayout.setBackgroundDrawable(ContextCompat.getDrawable(OrderHistoryActivity.this, R.drawable.convertlayout_rounded_shape));


        activeOrderHistoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeOrderHistoryLayout.setBackgroundDrawable(ContextCompat.getDrawable(OrderHistoryActivity.this, R.drawable.deposite_rounded_shape_left));
                completedOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);
                historicalOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);

                txtActiveOrderHistory.setTextColor(getResources().getColor(R.color.white));
                txtCompleteOrderHistory.setTextColor(getResources().getColor(R.color.black));
                txtHistoricalOrderHistory.setTextColor(getResources().getColor(R.color.black));
            }
        });

        completedOrderHistoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completedOrderHistoryLayout.setBackgroundDrawable(ContextCompat.getDrawable(OrderHistoryActivity.this, R.color.colorPrimary));
                activeOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);
                historicalOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);

                txtCompleteOrderHistory.setTextColor(getResources().getColor(R.color.white));
                txtActiveOrderHistory.setTextColor(getResources().getColor(R.color.black));
                txtHistoricalOrderHistory.setTextColor(getResources().getColor(R.color.black));
            }
        });

        historicalOrderHistoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historicalOrderHistoryLayout.setBackgroundDrawable(ContextCompat.getDrawable(OrderHistoryActivity.this, R.drawable.convertlayout_rounded_shape));
                activeOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);
                completedOrderHistoryLayout.setBackgroundColor(Color.TRANSPARENT);

                txtHistoricalOrderHistory.setTextColor(getResources().getColor(R.color.white));
                txtCompleteOrderHistory.setTextColor(getResources().getColor(R.color.black));
                txtActiveOrderHistory.setTextColor(getResources().getColor(R.color.black));
            }
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // finish();
            startActivity(new Intent(this, MenuActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MenuActivity.class));
    }
}
