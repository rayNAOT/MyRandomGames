package com.example.raymond.myrandomgames;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    /*
    TODO
    * Rock, paper, scissors, spock, lizard
    * Add prompts to indicate why a player has won/lost
    * Improve style and layout
    * Make database
     */

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;

    private static final int ROCK = 0;
    private static final int SPOCK = 1;
    private static final int PAPER = 2;
    private static final int LIZARD = 3;
    private static final int SCISSORS = 4;

    ImageView iv_cpu, iv_player;

    Button btn_rock, btn_spock, btn_paper, btn_lizard, btn_scissors, btn_save, btn_database;

    TextView tv_info, tv_playerWins, tv_CPUWins, tv_draw;

    Random r;

    int playedCPU, playedPLAYER, playerScore, CPUScore, draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        actionBar = getSupportActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_spock = (Button) findViewById(R.id.btn_spock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_lizard = (Button) findViewById(R.id.btn_lizard);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_database = (Button) findViewById(R.id.btn_database);

        tv_info = (TextView) findViewById(R.id.tv_info);

        tv_playerWins = (TextView) findViewById(R.id.tv_playerWins);
        tv_CPUWins = (TextView) findViewById(R.id.tv_CPUWins);
        tv_draw = (TextView) findViewById(R.id.tv_draw);

        r = new Random();

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        LinearLayout row1 = (LinearLayout) findViewById(R.id.lay_row1);
        LinearLayout row2 = (LinearLayout) findViewById(R.id.lay_row2);
        LinearLayout row3 = (LinearLayout) findViewById(R.id.lay_row3);
        LinearLayout row4 = (LinearLayout) findViewById(R.id.lay_row4);

        TextView tv = (TextView) findViewById(R.id.textView2);
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
                Intent intentLoadInfo = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(SecondActivity.this, "Home Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(SecondActivity.this, SecondActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(SecondActivity.this, "Rock, Paper, Scissors, Spock, Lizard Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(SecondActivity.this, "TicTacToe Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(SecondActivity.this, ForthActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(SecondActivity.this, "Cups Game Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playedPLAYER = ROCK;
                playedCPU = r.nextInt(5);
                setImages(playedPLAYER, playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPLAYER, playedCPU)));
            }
        });

        btn_spock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playedPLAYER = SPOCK;
                playedCPU = r.nextInt(5);
                setImages(playedPLAYER, playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPLAYER, playedCPU)));
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playedPLAYER = PAPER;
                playedCPU = r.nextInt(5);
                setImages(playedPLAYER, playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPLAYER, playedCPU)));
            }
        });

        btn_lizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playedPLAYER = LIZARD;
                playedCPU = r.nextInt(5);
                setImages(playedPLAYER, playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPLAYER, playedCPU)));
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playedPLAYER = SCISSORS;
                playedCPU = r.nextInt(5);
                setImages(playedPLAYER, playedCPU);
                tv_info.setText(getWinnerText(getWinner(playedPLAYER, playedCPU)));
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

    private int getWinner(int A, int B) { // This determines the winner
        return A == B ? 0 : (A - B + 5) % 5 <= 2 ? 1 : -1; // Returns 1 if A is the winner, returns -1 if B is the winner, returns 0 if it is a draw
    } // END getWinner class

    private String getWinnerText(int result) { // Converts result from the getWinner() method to text
        switch (result) {
            case 1:
                playerScore++;
                tv_playerWins.setText("" + playerScore);
                return "PLAYER Wins!";
            case -1:
                CPUScore++;
                tv_CPUWins.setText("" + CPUScore);
                return "CPU Wins!";
            case 0:
                draw++;
                tv_draw.setText("" + draw);
                return "Draw!";
            default:
                return "";
        }
    } // END getWinnerText Class

    private void setImages(int A, int B) {
        switch (A) {
            case ROCK:
                iv_player.setImageResource(R.drawable.rock);
                break;
            case SPOCK:
                iv_player.setImageResource(R.drawable.spock);
                break;
            case PAPER:
                iv_player.setImageResource(R.drawable.paper);
                break;
            case LIZARD:
                iv_player.setImageResource(R.drawable.lizard);
                break;
            case SCISSORS:
                iv_player.setImageResource(R.drawable.scissors);
                break;
        }

        switch (B) {
            case ROCK:
                iv_cpu.setImageResource(R.drawable.rock);
                break;
            case SPOCK:
                iv_cpu.setImageResource(R.drawable.spock);
                break;
            case PAPER:
                iv_cpu.setImageResource(R.drawable.paper);
                break;
            case LIZARD:
                iv_cpu.setImageResource(R.drawable.lizard);
                break;
            case SCISSORS:
                iv_cpu.setImageResource(R.drawable.scissors);
                break;
        }
    } // END setImages class
} // END SecondActivity superclass