package com.example.raymond.myrandomgames;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    TODO
    * Change colour of activity names in drawer to match selected activity
     */

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;

    TextView tv_RPSSL, tv_TTT, tv_CUPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_RPSSL = (TextView) findViewById(R.id.tv_RPSSL);
        tv_TTT = (TextView) findViewById(R.id.tv_TTT);
        tv_CUPS = (TextView) findViewById(R.id.tv_CUPS);

        actionBar = getSupportActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        LinearLayout row1 = (LinearLayout) findViewById(R.id.lay_row1);
        LinearLayout row2 = (LinearLayout) findViewById(R.id.lay_row2);
        LinearLayout row3 = (LinearLayout) findViewById(R.id.lay_row3);
        LinearLayout row4 = (LinearLayout) findViewById(R.id.lay_row4);

        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                actionBar.setTitle(getResources().getString(R.string.app_name));
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                actionBar.setTitle(getResources().getString(R.string.app_name));
            }
        };

        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        tv_RPSSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentLoadInfo);
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(MainActivity.this, "Rock, Paper, Scissors, Spock, Lizard Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        tv_TTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intentLoadInfo);
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(MainActivity.this, "TicTacToe Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        tv_CUPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, ForthActivity.class);
                startActivity(intentLoadInfo);
            }
        });

        row4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(MainActivity.this, ForthActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(MainActivity.this, "Cups Game Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });
    } // END onCreate class

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

} // END Main Activity superclass