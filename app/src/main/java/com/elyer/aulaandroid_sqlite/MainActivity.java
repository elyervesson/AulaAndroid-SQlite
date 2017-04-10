package com.elyer.aulaandroid_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.elyer.aulaandroid_sqlite.dao.DBManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> itens = null;
        DBManager dbManager = new DBManager(this);
        for (int i = 0; i < 10; i++) {
            dbManager.addItem("Item n° " + i);
        }

        itens = dbManager.getAllItens();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        ListView listView = (ListView) findViewById(R.id.listViewitems);
        listView.setAdapter(adapter);
    }
}
