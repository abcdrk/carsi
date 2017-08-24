package com.example.dilrubareyyan.carsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATAMASE_NAME = "dilrubareyyanDB";
    private static final String TABLE_NAME = "countries";

    public DBHelper(Context context){
        super(context, DATAMASE_NAME, null, 1);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " +  TABLE_NAME + " (id INTEGER PRIMARY KEY, country_name TEXT ) " ;
        sqLiteDatabase.execSQL(sql);
    }

    // On updates and version changes.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertCountry(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("country_name",name);

        db.insert(TABLE_NAME, null, values);

        db.close();

    }

    public List<String> getAllCountries(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> countryList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, new String[]{"id","country_name"}, null, null, null, null, null);

        while(cursor.moveToNext()){
            countryList.add(cursor.getString(1));
        }

        return countryList;
    }
}