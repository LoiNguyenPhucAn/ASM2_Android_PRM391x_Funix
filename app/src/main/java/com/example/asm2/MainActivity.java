package com.example.asm2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asm2.databinding.ActivityMainBinding;
import com.example.asm2.databinding.NavHeaderBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    ActionBarDrawerToggle toggle;
    DrawerLayout drawerMain;
    NavigationView navigationDrawerMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        setSupportActionBar(mainBinding.appbarContentLayout.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        drawerMain = mainBinding.drawerMain;
        toggle = new ActionBarDrawerToggle(this, drawerMain, R.string.Open, R.string.Close);
        drawerMain.addDrawerListener(toggle);
        toggle.syncState();

        navigationDrawerMain = mainBinding.navigationItemleft;
        navigationDrawerMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.itemSMS:
                        getSupportActionBar().setTitle(R.string.peding_sms);
                        break;

                    case R.id.itemPhone:
                        getSupportActionBar().setTitle(R.string.phone_call);
                        break;

                    case R.id.itemAlarm:
                        getSupportActionBar().setTitle(R.string.alarm);
                        break;
                }

                drawerMain.closeDrawer(GravityCompat.START);

                return true;
            }
        });



    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}