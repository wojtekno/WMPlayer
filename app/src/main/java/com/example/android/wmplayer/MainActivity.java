package com.example.android.wmplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Author> authorArrayList = new ArrayList<Author>();
        ArrayList<ArrayList<Song>> songDB = new ArrayList<ArrayList<Song>>();
        authorArrayList.add(new Author("BonJovi"));
        authorArrayList.add(new Author("Republika"));

        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorArrayList);
        GridView authorGridView = findViewById(R.id.authorlist_gv);
        authorGridView.setAdapter(authorListAdapter);
    }
}
