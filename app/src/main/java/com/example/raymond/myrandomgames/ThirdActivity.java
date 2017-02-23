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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    /*
    TODO
    * TicTacToe Game
    * Make database
     */

    DatabaseHelper myDb;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_reset, btn_save, btn_database;

    TextView tv_playerXwins, tv_playerOwins, tv_draw;

    int turn, playerXwins, playerOwins, draw;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myDb = new DatabaseHelper(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_database = (Button) findViewById(R.id.btn_database);

        turn = 1;

        actionBar = getSupportActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        LinearLayout row1 = (LinearLayout) findViewById(R.id.lay_row1);
        LinearLayout row2 = (LinearLayout) findViewById(R.id.lay_row2);
        LinearLayout row3 = (LinearLayout) findViewById(R.id.lay_row3);
        LinearLayout row4 = (LinearLayout) findViewById(R.id.lay_row4);

        TextView tv = (TextView) findViewById(R.id.textView3);
        tv.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));

        addData();
        viewAll();

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
                Intent intentLoadInfo = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ThirdActivity.this, "Home Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ThirdActivity.this, "Rock, Paper, Scissors, Spock, Lizard Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ThirdActivity.this, ThirdActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ThirdActivity.this, "TicTacToe Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        row4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadInfo = new Intent(ThirdActivity.this, ForthActivity.class);
                startActivity(intentLoadInfo);
                Toast.makeText(ThirdActivity.this, "Cups Game Selected!", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn1.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn1.setText("O");
                    }
                }
                endGame();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn2.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn2.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn2.setText("O");
                    }
                }
                endGame();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn3.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn3.setText("O");
                    }
                }
                endGame();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn4.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn4.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn4.setText("O");
                    }
                }
                endGame();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn5.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn5.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn5.setText("O");
                    }
                }
                endGame();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn6.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn6.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn6.setText("O");
                    }
                }
                endGame();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn7.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn7.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn7.setText("O");
                    }
                }
                endGame();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn8.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn8.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn8.setText("O");
                    }
                }
                endGame();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn9.getText().toString().equals("")) {
                    if (turn == 1) {
                        turn = 2;
                        btn9.setText("X");
                    } else if (turn == 2) {
                        turn = 1;
                        btn9.setText("O");
                    }
                }
                endGame();
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                startGame();
            }
        });
    } // END onCreate class

    public void addData() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(tv_playerXwins.getText().toString(),
                        tv_playerOwins.getText().toString(),
                        tv_draw.getText().toString());
                if (isInserted) {
                    Toast.makeText(ThirdActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ThirdActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    } // END addData class

    public void viewAll() {
        btn_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID: " + res.getString(0) + "\n");
                    buffer.append("Player X Wins: " + res.getString(1) + "\n");
                    buffer.append("Player O Wins: " + res.getString(2) + "\n");
                    buffer.append("Draws: " + res.getString(3) + "\n\n");
                }
                showMessage("Data", buffer.toString());
            }
        });
    } // END viewAll class

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    } // END showMessage class

    public void startGame () {
        boolean start = true;
        if (start) {
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
        }
    } // END startGame class

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

    public void endGame() {
        String a, b, c, d, e, f, g, h, i;

        boolean end = false;
        boolean drawCheck = true;

        tv_playerXwins = (TextView) findViewById(R.id.tv_playerXwins);
        tv_playerOwins = (TextView) findViewById(R.id.tv_playerOwins);
        tv_draw = (TextView) findViewById(R.id.tv_draw);

        a = btn1.getText().toString(); b = btn2.getText().toString(); c = btn3.getText().toString();
        d = btn4.getText().toString(); e = btn5.getText().toString(); f = btn6.getText().toString();
        g = btn7.getText().toString(); h = btn8.getText().toString(); i = btn9.getText().toString();

        if (a.equals("X") && b.equals("X") && c.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (d.equals("X") && e.equals("X") && f.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (g.equals("X") && h.equals("X") && i.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (a.equals("X") && d.equals("X") && g.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (b.equals("X") && e.equals("X") && h.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (c.equals("X") && f.equals("X") && i.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (a.equals("X") && e.equals("X") && i.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (c.equals("X") && e.equals("X") && g.equals("X")) {
            playerXwins++;
            tv_playerXwins.setText("" + playerXwins);
            Toast.makeText(ThirdActivity.this, "Player X Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (a.equals("O") && b.equals("O") && c.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (d.equals("O") && e.equals("O") && f.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (g.equals("O") && h.equals("O") && i.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (a.equals("O") && d.equals("O") && g.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (b.equals("O") && e.equals("O") && h.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (c.equals("O") && f.equals("O") && i.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (a.equals("O") && e.equals("O") && i.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }
        if (c.equals("O") && e.equals("O") && g.equals("O")) {
            playerOwins++;
            tv_playerOwins.setText("" + playerOwins);
            Toast.makeText(ThirdActivity.this, "Player O Wins!", Toast.LENGTH_SHORT).show();
            drawCheck = false;
            end = true;
        }

        if (end) {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }

        if (!a.equals("") && !b.equals("") && !c.equals("") &&
                !d.equals("") && !e.equals("") && !f.equals("") &&
                !g.equals("") && !h.equals("") && !i.equals("") &&
                drawCheck == true){
            draw++;
            tv_draw.setText("" + draw);
            Toast.makeText(ThirdActivity.this, "Draw!", Toast.LENGTH_SHORT).show();
        }
    } // END endGame class
} // END ThirdActivity superclass