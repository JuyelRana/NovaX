package com.dreamfactory.novax.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;

public class AmendCancelOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolBarBalance;
    private Button btn_amend_order, btn_cancel_order;

    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend_cancel_order);

        btn_amend_order = findViewById(R.id.btn_amend_order);
        btn_cancel_order = findViewById(R.id.btn_cancel_order);

        toolBarBalance = findViewById(R.id.toolBarBalance);
        toolBarBalance.setTitle(R.string.US_NVIDIA);
        setSupportActionBar(toolBarBalance);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btn_cancel_order.setOnClickListener(this);
        btn_amend_order.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        } else if (item.getItemId() == R.id.item_menu_search) {
            Toast.makeText(this, "Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_amend_order:
                startActivity(new Intent(getApplicationContext(), AmendOrder.class));
                break;

            case R.id.btn_cancel_order:
                //Toast.makeText(AmendCancelOrderActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                setCancelDialog();
                break;
        }
    }


    public void setCancelDialog() {
        final Dialog dialog = new Dialog(AmendCancelOrderActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cancel_order_dialog);

        TextView txtDialog = dialog.findViewById(R.id.txtDialog);
        TextView txtYeas = dialog.findViewById(R.id.txtYeas);
        TextView txtNo = dialog.findViewById(R.id.txtNo);

        txtDialog.setText("Do you want to cancel this order?");
        txtYeas.setText("Yes");
        txtNo.setText("No");

        txtYeas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmendCancelOrderActivity.this, "Clicked Yes", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                setCancelProgress();
            }
        });

        txtNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmendCancelOrderActivity.this, "Clicked No", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void setCancelProgress() {
        final Dialog dialog = new Dialog(AmendCancelOrderActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_processing_cancel_order_dialog);

        TextView txtWait = dialog.findViewById(R.id.txtWait);
        ProgressBar progressBar = dialog.findViewById(R.id.cancelOrderProgressBar);
        progressBar.setVisibility(View.VISIBLE);
        txtWait.setText("Please wait....");
        dialog.show();
        // setProgressValue(dialog, progressBar);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                dialog.dismiss();
                cancelMessage();
            }

        }, 1500);


    }

    private void cancelMessage() {
        final Dialog dialog = new Dialog(AmendCancelOrderActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cancel_order_message);
        TextView txtYeasMessage = dialog.findViewById(R.id.txtYeasMessage);
        TextView txtDialogMessage = dialog.findViewById(R.id.txtDialogMessage);
        txtDialogMessage.setText("Your cancellation request has been received.");
        dialog.show();

        txtYeasMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(AmendCancelOrderActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setProgressValue(Dialog dialog, ProgressBar progressBar) {
        // set the progress
        progressBar.setVisibility(View.VISIBLE);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

        dialog.dismiss();
    }

}
