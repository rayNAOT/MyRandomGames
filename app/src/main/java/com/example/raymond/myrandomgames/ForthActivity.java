package com.example.raymond.myrandomgames;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForthActivity extends AppCompatActivity {
    /*
    TODO
    * Cups game
    * Add database to store correct and incorrect scores
    * Style game
    * */

    ImageView left, middle, right;

    TextView tv_correctGuesses, tv_incorrectGuesses;

    Button new_game;

    int totalCorrect, totalIncorrect;

    List<Integer> cards;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        actionBar = getSupportActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

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

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        LinearLayout row1 = (LinearLayout) findViewById(R.id.lay_row1);
        LinearLayout row2 = (LinearLayout) findViewById(R.id.lay_row2);
        LinearLayout row3 = (LinearLayout) findViewById(R.id.lay_row3);
        LinearLayout row4 = (LinearLayout) findViewById(R.id.lay_row4);

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ForthActivity.this, MainActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ForthActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ForthActivity.this, SecondActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ForthActivity.this, "Rock, Paper, Scissors, Spock, Lizard Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ForthActivity.this, ThirdActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ForthActivity.this, "TicTacToe Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ForthActivity.this, ForthActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ForthActivity.this, "Cups Game Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        left = (ImageView) findViewById(R.id.left);
        middle = (ImageView) findViewById(R.id.middle);
        right = (ImageView) findViewById(R.id.right);

        tv_correctGuesses = (TextView) findViewById(R.id.tv_correctGuesses);
        tv_incorrectGuesses = (TextView) findViewById(R.id.tv_incorrectGuesses);

        new_game = (Button) findViewById(R.id.new_game);

        cards = new ArrayList<>();
        cards.add(107); // ace of spades
        cards.add(207); // 2 of hearts
        cards.add(407); // 2 of diamonds

        Collections.shuffle(cards); // Shuffle the cards

        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Shuffle the cards
                Collections.shuffle(cards);

                left.setImageResource(R.drawable.playing_card_back);
                middle.setImageResource(R.drawable.playing_card_back);
                right.setImageResource(R.drawable.playing_card_back);

                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);

            }
        });

        totalCorrect = 0;
        totalIncorrect = 0;

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assign images
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_of_spades);
                    totalCorrect++;
                    tv_correctGuesses.setText("" + totalCorrect);
                    Toast.makeText(ForthActivity.this, "Correct Guess!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.two_of_hearts);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.two_of_diamonds);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.two_of_diamonds);
                }
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.two_of_diamonds);
                }
            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assign images
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_of_spades);
                    totalCorrect++;
                    tv_correctGuesses.setText("" + totalCorrect);
                    Toast.makeText(ForthActivity.this, "Correct Guess!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.two_of_hearts);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.two_of_diamonds);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.two_of_diamonds);
                }
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.two_of_diamonds);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assign images
                if (cards.get(2) == 107) {
                    right.setImageResource(R.drawable.ace_of_spades);
                    totalCorrect++;
                    tv_correctGuesses.setText("" + totalCorrect);
                    Toast.makeText(ForthActivity.this, "Correct Guess!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 207) {
                    right.setImageResource(R.drawable.two_of_hearts);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 407) {
                    right.setImageResource(R.drawable.two_of_diamonds);
                    totalIncorrect++;
                    tv_incorrectGuesses.setText("" + totalIncorrect);
                    Toast.makeText(ForthActivity.this, "Try Again!", Toast.LENGTH_SHORT).show();
                }
                if (cards.get(0) == 107) {
                    left.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(0) == 207) {
                    left.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(0) == 407) {
                    left.setImageResource(R.drawable.two_of_diamonds);
                }
                if (cards.get(1) == 107) {
                    middle.setImageResource(R.drawable.ace_of_spades);
                } else if (cards.get(1) == 207) {
                    middle.setImageResource(R.drawable.two_of_hearts);
                } else if (cards.get(1) == 407) {
                    middle.setImageResource(R.drawable.two_of_diamonds);
                }
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

} // END ForthActivity superclass