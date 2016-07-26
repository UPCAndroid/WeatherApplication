package com.example.administrator.weatherapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.weatherapplication.database.SQLite;

import java.util.ArrayList;
import java.util.List;

public class CityList extends AppCompatActivity  implements SearchView.OnQueryTextListener{
    private SearchView searchCity;
    private ListView searchList;
    List<String> list = new ArrayList<String>();
    Adapter adapter;


    public void DeleteCity(String city){
        SQLite db;
        db = new SQLite(this,"WEATHER",null,7);
        db.getWritableDatabase();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        sqLiteDatabase.execSQL("DELETE FROM WEATHER WHERE CITY=?",new String[] {city});
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);




        SQLite db;
        db = new SQLite(this,"WEATHER",null,7);
        db.getWritableDatabase();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

//        db.onUpgrade(sqLiteDatabase,1,2);



/*        sqLiteDatabase.execSQL("INSERT INTO WEATHER (CITY) VALUES(?)",new String[] {"上海"});
        sqLiteDatabase.execSQL("INSERT INTO WEATHER (CITY) VALUES(?)",new String[] {"北京"});*/



        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM WEATHER",null);

        if(cursor.moveToFirst()){
            do{
                list.add(cursor.getString(cursor.getColumnIndex("CITY")));
            }while (cursor.moveToNext());
        }
        cursor.close();
        searchList = (ListView)findViewById(R.id.search_already_list);
        searchCity = (SearchView) findViewById(R.id.search_already_city);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        searchList.setAdapter((ListAdapter) adapter);
        searchList.setTextFilterEnabled(true);
        searchCity.setIconifiedByDefault(false);
        searchCity.setOnQueryTextListener(this);
        searchCity.setSubmitButtonEnabled(false);
        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Toast.makeText(CityList.this,list.get(i)+"已被删除",Toast.LENGTH_LONG).show();
                DeleteCity(list.get(i));
                Intent intent = new Intent(CityList.this,MainActivity.class);
                startActivity(intent);



            }
        });


    }
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            searchList.clearTextFilter();
        } else {
            searchList.setFilterText(newText);
        }
        return true;
    }
    // 单击搜索按钮时激发该方法
    @Override
    public boolean onQueryTextSubmit(String query) {

        Toast.makeText(this, "您的选择是:" + query, Toast.LENGTH_SHORT).show();
        return false;
    }


}
