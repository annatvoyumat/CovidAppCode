package com.example.covid19cv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "report.db";
    public static final String DataBase = "report";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(@Nullable Context context) {
        super(context, DB_Name, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table " + DataBase + "(id INTEGER PRIMARY KEY AUTOINCREMENT, municipality TEXT NOT NULL,symptoms TEXT, startDate TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists " + DataBase);
        onCreate(DB);
    }

    public Boolean insertCase(String municipality, String startDate,String symptoms){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("municipality", municipality);
        contentValues.put("Symptoms", symptoms);
        contentValues.put("StartDate", startDate);
        long id = db.insert(DataBase, null, contentValues);
        if(id == -1)
            return false;
        else
            return true;
    }

    public Cursor findReportsByMunicipality(String name){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + DataBase + " WHERE municipality = '" + name + "'", null);
        return cursor;
    }
}

