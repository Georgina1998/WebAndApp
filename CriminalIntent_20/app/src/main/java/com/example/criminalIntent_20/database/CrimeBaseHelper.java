package com.example.criminalIntent_20.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.criminalIntent_20.database.CrimeDbSchema.CrimeTable;

import static com.example.criminalIntent_20.database.CrimeDbSchema.CrimeTable.NAME;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public static SQLiteDatabase db;

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + NAME + "(" +
                " _id integer primary key autoincrement, " +
                CrimeTable.Cols.UUID + ", " +
                CrimeTable.Cols.TITLE + ", " +
                CrimeTable.Cols.DETAILS + ", " +
                CrimeTable.Cols.DATE + ", " +
                CrimeTable.Cols.TIME + ", " +
                CrimeTable.Cols.SOLVED + ", " +
                CrimeTable.Cols.SDESC + ", " +
                CrimeTable.Cols.SUSPECT + 
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static int deleteData(String id){
        String where="ID=?";
        int numOfEntries = db.delete(NAME, where, new String[]{id});
        return numOfEntries;
    }
}