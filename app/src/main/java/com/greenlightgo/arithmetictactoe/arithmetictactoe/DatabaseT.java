package com.greenlightgo.arithmetictactoe.arithmetictactoe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Grand on 12/4/2014.
 */
public class DatabaseT {
    public static final String KEY_ID ="_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_LEVEL = "level";

    private static final String DATABASE_NAME = "SuperPlayersdb";
    private static final String TABLE_NAME = "Players";
    private static final int DATABASE_VERSION = 1;

    private Dbhelper dbhelper;
    private final Context ourContext;
    private SQLiteDatabase database;

    public String getData() {
        String[] columns = new String[]{ KEY_ID, KEY_NAME, KEY_LEVEL};
        Cursor c = database.query(TABLE_NAME, columns, null,null,null,null,null);
        String result = "  ";

        int iRow = c.getColumnIndex(KEY_ID);
        int iName = c.getColumnIndex(KEY_NAME);
        int iLevel = c.getColumnIndex(KEY_LEVEL);

        for (c.moveToFirst();!c.isAfterLast(); c.moveToNext()){
            result = result + c.getString(iRow) + "  " + c.getString(iName)+
                    "  " + c.getString(iLevel) + "\n";
        }


        return result;
    }


    private static class Dbhelper extends SQLiteOpenHelper {
        public Dbhelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_LEVEL + "TEXT NOT NULL); "

            );

        }
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion,int newVersion){
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
    }
    public DatabaseT(Context c){
        ourContext = c;
    }
    public  DatabaseT open()throws SQLException{
        dbhelper = new Dbhelper(ourContext);
        database = dbhelper.getWritableDatabase();
        return this;
    }
    public void close(){
        dbhelper.close();
    }
    public long createEntry(String name, String level){
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_LEVEL,level);
        return database.insert(TABLE_NAME,null,cv);

    }

}
