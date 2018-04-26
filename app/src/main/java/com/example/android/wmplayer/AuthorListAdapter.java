package com.example.android.wmplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wojtek on 4/20/2018.
 */

public class AuthorListAdapter extends ArrayAdapter<Author> {

    OnAuthorItemClickListener callback;

    public AuthorListAdapter(Context context, ArrayList<Author> authorArrayList, OnAuthorItemClickListener callback) {
        super(context, 0, authorArrayList);
        this.callback = callback;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.author_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Author currentAuthor = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView authorsName = (TextView) listItemView.findViewById(R.id.authors_name_tv);
        authorsName.setText(currentAuthor.getAuthorName());


        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemClick(position);
            }
        });
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberOfTracks = (TextView) listItemView.findViewById(R.id.number_of_tracks);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberOfTracks.setText(String.valueOf(currentAuthor.getSongsOfAuthor().size()));

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }

    //TODO what params to pass?
    public interface OnAuthorItemClickListener {
        //        public void onItemClick(int position, Author currentAuthor);
        void onItemClick(int position);

    }
}

