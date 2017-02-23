package com.example.raymond.myrandomgames;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Raymond on 21/02/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "myRandomgames.db";
    public static final String TABLE_NAME = "TTT_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "playerXwins";
    public static final String COL_3 = "playerOwins";
    public static final String COL_4 = "draws";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "playerXwins INTEGER, " +
                "playerOwins INTEGER, " +
                "draws INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String playerXwins, String playerOwins, String draws) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, playerXwins);
        contentValues.put(COL_3, playerOwins);
        contentValues.put(COL_4, draws);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    } // END insertData class

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }
} // END DatabaseHelper class
