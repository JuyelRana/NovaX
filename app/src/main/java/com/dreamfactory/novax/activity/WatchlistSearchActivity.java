package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.adapter.WatchlistSearchAdapter;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistSearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    RecyclerView watchlistRecyclerView;
    WatchlistSearchAdapter adapter;
    List<Watchlist> watchlistsSearch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist_search_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar_watchlistSearch);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(WatchlistSearchActivity.this, R.color.colorPrimary));
        watchlistRecyclerView = findViewById(R.id.watchlistearchRecycler);
        watchlistRecyclerView.setHasFixedSize(false);
        watchlistRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        watchlistsSearch.clear();
        watchlistsSearch.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "1"));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_facebook, "US: FACEBOOK", "40", "15", "30,372.50", "4,500", ""));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "1"));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_facebook, "US: FACEBOOK", "40", "15", "30,372.50", "4,500", ""));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "1"));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_facebook, "US: FACEBOOK", "40", "15", "30,372.50", "4,500", ""));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "1"));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_facebook, "US: FACEBOOK", "40", "15", "30,372.50", "4,500", ""));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "1"));
        watchlistsSearch.add(new Watchlist(R.drawable.icon_facebook, "US: FACEBOOK", "40", "15", "30,372.50", "4,500", ""));

        adapter = new WatchlistSearchAdapter(watchlistsSearch, this);
        watchlistRecyclerView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_watchlistSearch);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_watchlistSearch);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_watchlistsearch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.item_menu_search_watchlist:
                Intent intent = new Intent(this, WatchlistSearchActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("tabSlector", 0);
                startActivity(intent);

                // startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.nav_portfolio:
                Intent intent1 = new Intent(getApplicationContext(), MenuActivity.class);
                intent1.putExtra("tabSlector", 1);
                startActivity(intent1);

                // startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.nav_balance:
                startActivity(new Intent(getApplicationContext(), BalanceActivity.class));
                break;

            case R.id.nav_watchlist:
                startActivity(new Intent(getApplicationContext(), WatchlistActivity.class));
                break;

            case R.id.nav_orders:
                Intent intent2 = new Intent(getApplicationContext(), MenuActivity.class);
                intent2.putExtra("tabSlector", 2);
                startActivity(intent2);

                // startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.nav_social_traders:
                Intent intent3 = new Intent(getApplicationContext(), MenuActivity.class);
                intent3.putExtra("tabSlector", 3);
                startActivity(intent3);

            //    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.nav_contact_us:
                startActivity(new Intent(getApplicationContext(), ContactUsActivity.class));
                break;
            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_watchlistSearch);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_watchlistSearch);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
