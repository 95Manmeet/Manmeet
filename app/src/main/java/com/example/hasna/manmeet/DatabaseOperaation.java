package com.example.hasna.manmeet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by manmeet on 6/27/2018.
 */

public class DatabaseOperaation extends SQLiteOpenHelper{

    public  static String getPassword="";


    public static final int database_version=1;
    public String CREATE_QUERY = "CREATE TABLE " + TableData.users.TABLE_NAME + "("+ TableData.users.USERNAME +" TEXT," + TableData.users.PASSWORD + " TEXT,"+ TableData.users.EMAIL + " TEXT );";


    public DatabaseOperaation(Context context) {
        super(context, TableData.users.DATABASE_NAME, null, database_version);
        Log.d("MY MSG","Database Created");
    }


    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("MY MSG","Login Table Created");
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TableData.users.TABLE_NAME + "'");
        onCreate(db);
    }


    public void dropDatabase(DatabaseOperaation dop){
        SQLiteDatabase mydb = dop.getWritableDatabase();
        mydb.execSQL("DROP TABLE " + TableData.users.TABLE_NAME);
        Log.d("MY MSG"," Login Tables Deleted!");
    }


    public void putRecord(DatabaseOperaation dop, String username, String password, String email){
        SQLiteDatabase mydb = dop.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put(TableData.users.USERNAME,username);
        cv.put(TableData.users.PASSWORD,password);
        cv.put(TableData.users.EMAIL,email);
        long value = mydb.insert(TableData.users.TABLE_NAME,null,cv);
        Log.d("MY MSG","Row Inserted");
    }

    public Cursor getRecord(DatabaseOperaation dop){
        SQLiteDatabase DB = dop.getReadableDatabase();
        String[] data = {TableData.users.USERNAME,TableData.users.PASSWORD,TableData.users.EMAIL};
        Cursor cr = DB.query(TableData.users.TABLE_NAME,data,null,null,null,null,null);
        Log.d("MY MSG", "Getting Records...");
        return cr;
    }

    // method to get the password  of userName
    public String getSinlgeEntry(String userName)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query("users", null, "USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
            return "USER NOT EXIST";
        cursor.moveToFirst();
        getPassword= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return getPassword;
    }

}
