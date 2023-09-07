package com.example.vicky.e_coin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    public static final String Col_1 = "user";
    public static final String Col_2 = "password";
    public static final String DATABASE_TABLE = "users";
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }
    public void close(){
        if (db!=null){
            this.db.close();
        }
    }

    public boolean insertData(String username,String password){
        this.db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,username);
        contentValues.put(Col_2,password);

        long result =  db.insert(DATABASE_TABLE,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata(){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+DATABASE_TABLE,null);
        return result;
    }

    public boolean updatedata(String username,String password){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,username);
        contentValues.put(Col_2,password);

        db.update(DATABASE_TABLE,contentValues,"username = ?",new String[]{username});
        return true;
    }
    public String search(String username){
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(" SELECT user,password from users ",null);
        String a,b;
        b="Pass not found";
        if(cursor.moveToFirst()){

            do{

                a = cursor.getString(0);
                if(a.equals(username)){
                    b = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }

}
