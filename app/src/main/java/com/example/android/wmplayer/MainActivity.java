package com.example.android.wmplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Author> authorArrayList = new ArrayList<Author>();
        ArrayList<ArrayList<Song>> songDB = new ArrayList<ArrayList<Song>>();
        authorArrayList.add(new Author("BonJovi", 13));
        authorArrayList.add(new Author("Republika"));

        AuthorListAdapter authorListAdapter = new AuthorListAdapter(this, authorArrayList, new AuthorListAdapter.OnAuthorItemClickListener() {

            //TODO implementować tu, czy w adapterze?  implement it here or in AuthorListAdapter?
            @Override
            public void onItemClick(int position, Author currentAuthor) {
                Toast.makeText(MainActivity.this, "Toast w MainActivity", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SongListActivity.class);
                i.putExtra("name", currentAuthor.getAuthorsName() );
                i.putExtra("numberOfTracks", currentAuthor.getNumberOfTracks());
                startActivity(i);
            }
        });
        GridView authorGridView = findViewById(R.id.authorlist_gv);
        authorGridView.setAdapter(authorListAdapter);

        //how to findView from outside the activit??
//        TextView authorsListLayout = (TextView) findViewById(R.id.authors_name_tv);
//        authorsListLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "lala", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MainActivity.this, SongListActivity.class);
//                startActivity(i);
//            }
//        });

    }


}
