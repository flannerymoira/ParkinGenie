package com.example.splashscreenjpg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Parkingenie.db";
    public static final String CARPARK_TABLE_NAME = "carPark";
    public static final String CARPARK1 = "carParkId";
    public static final String CARPARK2 = "userId";
    public static final String CARPARK3 = "name";
    public static final String CARPARK4 = "website";
    public static final String CARPARK5 = "address";
    public static final String CARPARK6 = "phone";
    public static final String CARPARK7 = "gps";
    public static final String CARPARK8 = "tot_spaces";
    public static final String CARPARK9 = "free_spaces";
    public static final String CARPARK10 = "height_restrictions";
    public static final String CARPARK11 = "payment_methods";


    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CARPARK_TABLE_NAME + "(carParkId INTEGER PRIMARY KEY AUTOINCREMENT, userId INTEGER, name TEXT, " +
                "website TEXT, address TEXT, phone TEXT, gps TEXT, tot_spaces INTEGER, free_spaces INTEGER, " +
                "height_restrictions TEXT, payment_methods TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CARPARK_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String website, String address,
                              String phone, String gps, Integer tot_spaces, Integer free_spaces,
                              String height_restrictions, String payment_methods){
        SQLiteDatabase myDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARPARK2,1);
        contentValues.put(CARPARK3,name);
        contentValues.put(CARPARK4,website);
        contentValues.put(CARPARK5,address);
        contentValues.put(CARPARK6,phone);
        contentValues.put(CARPARK7,gps);
        contentValues.put(CARPARK8,tot_spaces);
        contentValues.put(CARPARK9,free_spaces);
        contentValues.put(CARPARK10,height_restrictions);
        contentValues.put(CARPARK11,payment_methods);
        long result = myDb.insert(CARPARK_TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getOwnersCarpark(){
        SQLiteDatabase myDb = this.getWritableDatabase();
        Cursor result = myDb.rawQuery("Select carParkId, name, address from "+CARPARK_TABLE_NAME,null);
        return result;
    }
}
