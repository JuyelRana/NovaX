package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.MenuPageAdapter;
import com.dreamfactory.novax.fragment.MenuHomeFragment;
import com.dreamfactory.novax.fragment.MenuOrderFragment;
import com.dreamfactory.novax.fragment.MenuPortfoiloFragment;
import com.dreamfactory.novax.fragment.MenuSocialFragment;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private Toolbar toolbar;
    private TabLayout menuTabLayout;
    private TabItem menuTabItemHome;
    private TabItem menuTabItemPortfoilo;
    private TabItem menuTabItemOrder;
    private TabItem menuTabItemSocial;
    private ViewPager menuViewPager;
    private MenuPageAdapter menuPageAdapter;
    private ImageView nav_img_editIcon;

    private int tabSelector = 0;

    final int[] tabSelected = {
            R.drawable.icon_summary_home,
            R.drawable.icon_summary_portfoilo_white,
            R.drawable.icon_summary_order_white,
            R.drawable.icon_summary_social_trading_white};

    final int[] tabsUnselected = {
            R.drawable.icon_summary_home_black,
            R.drawable.icon_summary_portfoilo,
            R.drawable.icon_summary_order,
            R.drawable.icon_summary_social};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        tabSelector = getIntent().getIntExtra("tabSlector", 0);


        // Updated by Atikur Rahman

        //settup toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //settup toolbar

        //setup tab option
        menuTabLayout = findViewById(R.id.menu_tab_layout);
        menuTabItemHome = findViewById(R.id.tab_item_home);
        menuTabItemPortfoilo = findViewById(R.id.tab_item_portfoilo);
        menuTabItemOrder = findViewById(R.id.tab_item_order);
        menuTabItemSocial = findViewById(R.id.tab_item_social);
        menuViewPager = findViewById(R.id.menu_viewpager);
        //nav_img_editIcon = findViewById(R.id.nav_img_editIcon);

        // nav bar edit icon implementation
//        nav_img_editIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MenuActivity.this, "Edit Icon Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), menuTabLayout.getTabCount());
        menuViewPager.setAdapter(menuPageAdapter);
        //setup tab

        //setting navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //end setting navigation drawer


        menuViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(menuTabLayout));


        //setting tab selected listner so that we can change selected or unselected tab items background
        menuTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                menuViewPager.setCurrentItem(tab.getPosition());

                toolbar.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                menuTabLayout.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                }

                setToolBarTitle(tab.getPosition());


                if (tab.getPosition() == 0) {
                    // menuTabItemPortfoilo.setBackground(getDrawable(R.drawable.icon_portfolios_white));
                    menuTabLayout.getTabAt(0).setIcon(tabSelected[0]);
                    menuTabLayout.getTabAt(1).setIcon(tabsUnselected[1]);
                    menuTabLayout.getTabAt(2).setIcon(tabsUnselected[2]);
                    menuTabLayout.getTabAt(3).setIcon(tabsUnselected[3]);


                } else if (tab.getPosition() == 1) {
                    //  menuTabItemPortfoilo.setBackgroundDrawable(getDrawable(R.drawable.icon_portfolios_white));
                    menuTabLayout.getTabAt(0).setIcon(tabsUnselected[0]);
                    menuTabLayout.getTabAt(1).setIcon(tabSelected[1]);
                    menuTabLayout.getTabAt(2).setIcon(tabsUnselected[2]);
                    menuTabLayout.getTabAt(3).setIcon(tabsUnselected[3]);

                } else if (tab.getPosition() == 2) {
                    //  menuTabItemOrder.setBackgroundDrawable(getDrawable(R.drawable.icon_portfolios_white));
                    menuTabLayout.getTabAt(2).setIcon(tabSelected[2]);
                    menuTabLayout.getTabAt(1).setIcon(tabsUnselected[1]);
                    menuTabLayout.getTabAt(0).setIcon(tabsUnselected[0]);
                    menuTabLayout.getTabAt(3).setIcon(tabsUnselected[3]);

                } else {
                    //  menuTabItemSocial.setBackgroundDrawable(getDrawable(R.drawable.icon_portfolios_white));
                    menuTabLayout.getTabAt(2).setIcon(tabsUnselected[2]);
                    menuTabLayout.getTabAt(1).setIcon(tabsUnselected[1]);
                    menuTabLayout.getTabAt(0).setIcon(tabsUnselected[0]);
                    menuTabLayout.getTabAt(3).setIcon(tabSelected[3]);

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        if (tabSelector == 0) {
            menuViewPager.setCurrentItem(0, true);
        } else if (tabSelector == 1) {
            menuViewPager.setCurrentItem(1, true);
        } else if (tabSelector == 2) {
            menuViewPager.setCurrentItem(2, true);
        } else if (tabSelector == 3) {
            menuViewPager.setCurrentItem(3, true);
        }
        else {

        }

    }

//    @Override
//    public void onPageSelected(int position) {
//
//        int size = 4;
//        position = Math.min(position, size);
//
//        for(int i = 0; i <= size; i++){
//            if(i == position){
//                tabLayout.getTabAt(i).setIcon(tabSelected[i]);
//            }
//            else {
//                tabLayout.getTabAt(i).setIcon(tabsUnselected[i]);
//            }
//        }
//
//    }

    private void setToolBarTitle(int position) {
        switch (position) {

            case 0:
                toolbar.setTitle("Home");
                break;

            case 1:
                toolbar.setTitle("Portfolios");
                // menuTabItemPortfoilo.setBackground(getDrawable(R.drawable.icon_portfolios_white));
                // menuTabItemPortfoilo.setBackgroundDrawable(getDrawable(R.drawable.icon_portfolios_white));
                break;

            case 2:
                toolbar.setTitle("Orders");
                break;

            case 3:
                toolbar.setTitle("Social Trading");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.item_menu_search) {
            Toast.makeText(getApplicationContext(), "Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        switch (item.getItemId()) {

            case R.id.nav_home:
                //startActivity(new Intent(getApplicationContext(), MenuActivity.class));

                menuViewPager.setCurrentItem(0, true);
                break;

            case R.id.nav_portfolio:
                // startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                menuViewPager.setCurrentItem(1, true);
                break;

            case R.id.nav_balance:
                startActivity(new Intent(getApplicationContext(), BalanceActivity.class));
                break;

            case R.id.nav_watchlist:
                startActivity(new Intent(getApplicationContext(), WatchlistActivity.class));
                break;

            case R.id.nav_orders:
                // startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                menuViewPager.setCurrentItem(2, true);
                break;

            case R.id.nav_social_traders:
                //startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                menuViewPager.setCurrentItem(3, true);
                break;

            case R.id.nav_contact_us:
                startActivity(new Intent(getApplicationContext(), ContactUsActivity.class));
                break;
            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int positin) {

        int size = 3;
        int position = Math.min(positin, size);

        for (int i = 0; i <= size; i++) {
            if (i == position) {
                menuTabLayout.getTabAt(i).setIcon(tabSelected[i]);
            } else {
                menuTabLayout.getTabAt(i).setIcon(tabsUnselected[i]);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
