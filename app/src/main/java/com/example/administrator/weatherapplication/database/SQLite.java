package com.example.administrator.weatherapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by guozitian on 7/26/16.
 */
public class SQLite extends SQLiteOpenHelper {
    public static final String CREATE_TABLE =
            "CREATE TABLE WEATHER ("
                    + "CITY TEXT PRIMARY KEY,"
                    + "TEMP TEXT,"
                    + "WIND TEXT)";

    private Context mContext;

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }
/*
    private SQLite db;
    db = new SQLite(this,"WEATHER",null,1);*/

    private SQLite db;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
//        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXITS WEATHER");
        onCreate(sqLiteDatabase);
    }


    public void addData(){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO WEATHER (CITY,TEMP,WIND) VALUES(?,?,?)",new String[] {"Shanghai","30","af"});
    }

    public void updateData(){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE WEATHER SET TEMP = '?' WHERE CITY = '?'",new String[] {"28","Qingdao"});
    }

    public void removeData(){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM WEATHER WHERE CITY = '?'",new String[] {"Qingdao"});
    }

    public void queryData(){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("WEATHER",new String[]{"Column1,Column2"},"WHERE CITY=?",new String[]{"value of '?'"},null,null,null);
        if(cursor.moveToFirst()){
            do{
                String city = cursor.getString(cursor.getColumnIndex("CITY"));
                String wind = cursor.getString(cursor.getColumnIndex("WIND"));
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

}