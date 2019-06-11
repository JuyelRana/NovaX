package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dreamfactory.novax.R;

public class TestingActivity extends AppCompatActivity {

    Button loginBtn, welcomeBtn, menuBtn,deposite,watchlist,watchlistSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        loginBtn = findViewById(R.id.loginBtn);
        welcomeBtn = findViewById(R.id.welcomeBtn);
        menuBtn = findViewById(R.id.menuBtn);
        deposite = findViewById(R.id.deposite);
        watchlist = findViewById(R.id.watchlist);
        watchlistSearch = findViewById(R.id.watchlistSearch);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });
        welcomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, WelcomeActivity.class);
                startActivity(intent1);
            }
        });
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, MenuActivity.class);
                startActivity(intent1);
            }
        });
        deposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, DepositeActivity.class);
                startActivity(intent1);
            }
        });
        watchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, WatchlistActivity.class);
                startActivity(intent1);
            }
        });
        watchlistSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TestingActivity.this, WatchlistSearchActivity.class);
                startActivity(intent1);
            }
        });

    }
}
