package com.dreamfactory.novax.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dreamfactory.novax.R;

public class OrderConfirmActivity extends AppCompatActivity {

    private TextView txt_home,txt_orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                openAlert();
            }

        }, 1500);



    }

    private void openAlert() {

        Dialog dialog;
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.order_place_dialog);
        txt_home=dialog.findViewById(R.id.txt_home);
        txt_orders=dialog.findViewById(R.id.txt_orders);

        txt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderConfirmActivity.this,MenuActivity.class));
            }
        });

        txt_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderConfirmActivity.this,OrderHistoryActivity.class));
            }
        });

        dialog.show();
    }
}
