package com.example.splashscreenjpg;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null, cursor = null, cursorOpen ;
    public int carParkId;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // to return the single instance of the database
    public static DatabaseAccess getInstance(Context context) {
        if (instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    } // end

    //to open the database
    public void open(){
        this.db=openHelper.getWritableDatabase();
    }


    //close the database connection
    public void close(){
        if (db!=null) {
            this.db.close();
        }
    } // close

    public String getAddress(String name){
        c=db.rawQuery("select carParkId, address from carPark where name like '%"+name+"%'", new String[]{});
        StringBuffer buffer = new StringBuffer();

        while(c.moveToNext()){
                    String temp = c.getString(0);
                    carParkId = Integer.parseInt(temp);
                    String address = c.getString(1);
                    buffer.append(""+address);
        }

        return buffer.toString();
    } // getAddress

    public String getTariff(){
        cursor=db.rawQuery("select tariffInfo from tariff where carparkId = "+carParkId+" order by orderId", new String[]{});
        StringBuffer buffer = new StringBuffer();

        while(cursor.moveToNext()
        ){
            String tariffInfo = cursor.getString(0);
            buffer.append(""+tariffInfo+"\n");
        }

        return buffer.toString();
    } // getTariff

    public String getOpeningTimes(){
        cursorOpen=db.rawQuery("select dayOfWeek, openingInfo from openingTimes where carparkId = "+carParkId+" order by orderId", new String[]{});
        StringBuffer buffer = new StringBuffer();

        while(cursorOpen.moveToNext()){
            String dayOfWeek = cursorOpen.getString(0);
            buffer.append(""+dayOfWeek+"  ");
            String openingInfo = cursorOpen.getString(1);
            buffer.append(""+openingInfo+"\n");
        }

        return buffer.toString();
    } // getTariff

}
