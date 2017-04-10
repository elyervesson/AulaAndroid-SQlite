package com.elyer.aulaandroid_sqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elyer on 09/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "banco";
    private static int DB_VERSION = 1;

    private static String TABLE_ITENS =
            "CREATE TABLE itens(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT" +
            ");";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ITENS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
