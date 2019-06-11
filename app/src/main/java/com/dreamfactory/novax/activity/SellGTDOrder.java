package com.dreamfactory.novax.activity;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;

import java.util.Calendar;
import java.util.Random;

public class SellGTDOrder extends AppCompatActivity {

    private Toolbar toolBarSellGTDOrder;

    private TextView txtFirstValueSellGTDOrder, txtSecondValueSellGTDOrder, txtRealTimeUpdateSellGTDOrder;

    private LinearLayout llBuySellGTDOrderTab, llSellSellGDTOrderTab;
    private TextView txtBuySellGTDOrderTab, txtSellSellGTDOrderTab;

    private LinearLayout llSellGTDMKTOrder, llSellGTDLOOrder, llSellGTDGTDOrder;
    private TextView txtSellGTDMKTOrder, txtSellGTDLOOrder, txtSellGTDGTDOrder;
    private View viewSellGTDMKT, viewSellGTDLO, viewSellGTDGTD;

    private TextView txtAvailableForSellGTDValue, txtQuantitySellGTDValue, txtAmountSellGTDValue, txtExpiryDateGTDValue;

    private ProgressBar progressBarLimitPriceGTD, progressQuantityGTD;

    private int progress = 0;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_gtdorder);

        toolBarSellGTDOrder = findViewById(R.id.toolBarSellGTDOrder);
        toolBarSellGTDOrder.setTitle("Sell GTD Order");
        setSupportActionBar(toolBarSellGTDOrder);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        initializeProperty();
        implementationProperty();
    }


    private void initializeProperty() {
        txtFirstValueSellGTDOrder = findViewById(R.id.txtFirstValueSellGTDOrder);
        txtSecondValueSellGTDOrder = findViewById(R.id.txtSecondValueSellGTDOrder);
        txtRealTimeUpdateSellGTDOrder = findViewById(R.id.txtRealTimeUpdateSellGTDOrder);

        llBuySellGTDOrderTab = findViewById(R.id.llBuySellGTDOrderTab);
        llSellSellGDTOrderTab = findViewById(R.id.llSellSellGDTOrderTab);
        txtBuySellGTDOrderTab = findViewById(R.id.txtBuySellGTDOrderTab);
        txtSellSellGTDOrderTab = findViewById(R.id.txtSellSellGTDOrderTab);

        llSellGTDMKTOrder = findViewById(R.id.llSellGTDMKTOrder);
        llSellGTDLOOrder = findViewById(R.id.llSellGTDLOOrder);
        llSellGTDGTDOrder = findViewById(R.id.llSellGTDGTDOrder);

        txtSellGTDMKTOrder = findViewById(R.id.txtSellGTDMKTOrder);
        txtSellGTDLOOrder = findViewById(R.id.txtSellGTDLOOrder);
        txtSellGTDGTDOrder = findViewById(R.id.txtSellGTDGTDOrder);

        viewSellGTDMKT = findViewById(R.id.viewSellGTDMKT);
        viewSellGTDLO = findViewById(R.id.viewSellGTDLO);
        viewSellGTDGTD = findViewById(R.id.viewSellGTDGTD);

        txtAvailableForSellGTDValue = findViewById(R.id.txtAvailableForSellGTDValue);
        txtQuantitySellGTDValue = findViewById(R.id.txtQuantitySellGTDValue);
        txtAmountSellGTDValue = findViewById(R.id.txtAmountSellGTDValue);
        txtExpiryDateGTDValue = findViewById(R.id.txtExpiryDateGTDValue);

        progressBarLimitPriceGTD = findViewById(R.id.progressBarLimitPriceGTD);
        progressQuantityGTD = findViewById(R.id.progressQuantityGTD);

    }

    private void implementationProperty() {

        implementationllBuySellGTDOrderTab();
        implementationllSellSellGDTOrderTab();

        implementationllSellGTDMKTOrder();
        implementationllSellGTDLOOrder();
        implementationllSellGTDGTDOrder();

        implementationprogressBarLimitPriceGTD();
        implementationprogressQuantityGTD();

        llBuySellGTDOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.deposite_rounded_shape_left));
        txtBuySellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        llSellSellGDTOrderTab.setBackgroundColor(Color.TRANSPARENT);
        txtSellSellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        viewSellGTDMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));
    }

    private void implementationprogressQuantityGTD() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressQuantityGTD.setProgress(progress);
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

    private void implementationprogressBarLimitPriceGTD() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarLimitPriceGTD.setProgress(progress);
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

    private void implementationllSellGTDGTDOrder() {
        llSellGTDGTDOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressQuantityGTD();
                implementationprogressBarLimitPriceGTD();

                viewSellGTDGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));
                viewSellGTDMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTDLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllSellGTDLOOrder() {
        llSellGTDLOOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressQuantityGTD();
                implementationprogressBarLimitPriceGTD();

                viewSellGTDGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTDMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTDLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllSellGTDMKTOrder() {
        llSellGTDMKTOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressQuantityGTD();
                implementationprogressBarLimitPriceGTD();

                viewSellGTDGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTDMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));
                viewSellGTDLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllSellSellGDTOrderTab() {
        llSellSellGDTOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBuySellGTDOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtBuySellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                llSellSellGDTOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.convertlayout_rounded_shape));
                txtSellSellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                getNextValueForFirstTab();
            }
        });
    }

    private void implementationllBuySellGTDOrderTab() {
        llBuySellGTDOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBuySellGTDOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.deposite_rounded_shape_left));
                txtBuySellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llSellSellGDTOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtSellSellGTDOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                getNextValueForFirstTab();
            }
        });
    }

    private void getNextValueForSecondTab() {
        txtAvailableForSellGTDValue.setText("0." + getProgressData());
        txtQuantitySellGTDValue.setText("" + getProgressData());
        txtAmountSellGTDValue.setText(getProgressData() + "." + getProgressData());
        //txtExpiryDateGTDValue.setText("")
    }

    private void getNextValueForFirstTab() {
        txtFirstValueSellGTDOrder.setText("0." + getProgressData());
        txtSecondValueSellGTDOrder.setText("-0." + getProgressData());
        txtRealTimeUpdateSellGTDOrder.setText("Real Time, Last Updated " + getUpdatedRealTime());
    }

    private String getUpdatedRealTime() {
        return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    private int getProgressData() {
        return new Random().nextInt(100) + 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
