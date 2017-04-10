package com.elyer.aulaandroid_sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by elyer on 09/04/2017.
 */

public class DBManager {

    private static DBHelper dbHelper = null;

    public DBManager(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
    }

//    pode ser feito de ambas as formas
//    public void addItem(String nome) {
//        String sql = "INSERT INTO itens (name) VALUES ('" + nome + "');";
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.execSQL(sql);
//    }

    public void addItem(String nome) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        db.insert("itens", null, contentValues);
    }

    public ArrayList<String> getAllItens() {
        String sql = "SELECT * FROM itens";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<String> itens = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                itens.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return itens;
    }
}
