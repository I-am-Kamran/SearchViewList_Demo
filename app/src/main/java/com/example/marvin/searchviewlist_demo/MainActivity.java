package com.example.marvin.searchviewlist_demo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.marvin.searchviewlist_demo.R.array.months_array;

public class MainActivity extends AppCompatActivity {

private Toolbar toolbar;
private ListView listView;
private TextView textView;
private ArrayAdapter adapter;
    MyAdapter myAdapter;

private String[] data;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.emptyView);
        toolbar=findViewById(R.id.toolbar);
        listView=findViewById(R.id.list);

      //  setSupportActionBar(toolbar);
        data=getResources().getStringArray(R.array.months_array);

         myAdapter = new MyAdapter(this,data);
        listView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem mSearchView=menu.findItem(R.id.action_search);

        SearchView searchView= (SearchView) mSearchView.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
