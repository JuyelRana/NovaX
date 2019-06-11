package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.DetectSwipeGestureListener;

public class OrderDetailsActivity extends AppCompatActivity {

    private TextView orderDetailsProductDirection, orderDetailsProductType, orderDetailsProductQuantity, orderDetailsProductUpdated, orderDetailsProductNetAmount;
    private Button btn_buy_order;
    private Toolbar toolBarOrderDetails;
    private LottieAnimationView animationView;

    // This is the gesture detector compat instance.
    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        toolBarOrderDetails = findViewById(R.id.toolBarOrderDetails);
        btn_buy_order = findViewById(R.id.btn_buy_order);
        orderDetailsProductDirection = findViewById(R.id.orderDetailsProductDirection);
        orderDetailsProductType = findViewById(R.id.orderDetailsProductType);
        orderDetailsProductQuantity = findViewById(R.id.orderDetailsProductQuantity);
        orderDetailsProductUpdated = findViewById(R.id.orderDetailsProductUpdated);
        orderDetailsProductNetAmount = findViewById(R.id.orderDetailsProductNetAmount);
//        animationView = findViewById(R.id.animation);


        // Create a common gesture listener object.
        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();

        // Set activity in the listener.
        gestureListener.setActivity(this);

        // Create the gesture detector with the gesture listener.
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);


        toolBarOrderDetails.setTitle("Order Details");
        setSupportActionBar(toolBarOrderDetails);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btn_buy_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailsActivity.this, OrderConfirmActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Pass activity on touch event to the gesture detector.
        gestureDetectorCompat.onTouchEvent(event);
        // Return true to tell android OS that event has been consumed, do not pass it to other event listeners.
        return true;
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
            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        } else if (item.getItemId() == R.id.item_menu_search) {
            Toast.makeText(this, "Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayMessage(String message) {
        if (message != null) {
            // Display text in the text view.
            if (message.equals("Swipe to up")) {
                Intent intent = new Intent(OrderDetailsActivity.this, OrderConfirmActivity.class);
                startActivity(intent);
            }
        }
    }
}
