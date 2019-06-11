package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class ContactUsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private Toolbar toolbar;
    MapView mapView;
    GoogleMap googleMap;
    Marker mCurrLocationMarker;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus_menu);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        floatingActionButton = findViewById(R.id.fabbtn_contactus_page);

        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(ContactUsActivity.this, R.color.colorPrimary));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_contactus);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_contactus);
        navigationView.setNavigationItemSelectedListener(this);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContactUsActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.item_menu_search:
//                Intent intent=new Intent(this,WatchlistSearchActivity.class);
//                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

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

             //   startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                break;

            case R.id.nav_contact_us:
                //               startActivity(new Intent(getApplicationContext(), ContactUsActivity.class));
                break;
            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_contactus);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_contactus);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng latLng = new LatLng(22.282599, 114.154688);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(18));
    }
}
