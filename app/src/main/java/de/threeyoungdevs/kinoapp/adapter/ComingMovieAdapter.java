package de.threeyoungdevs.kinoapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import de.threeyoungdevs.kinoapp.MovieDetails;
import de.threeyoungdevs.kinoapp.R;

public class ComingMovieAdapter extends RecyclerView.Adapter<ComingMovieAdapter.MyViewHolder> {
    private String[] mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;

        public TextView movie_name;
        public ImageView movie_poster;

        public MyViewHolder(View v) {
            super(v);
            view = v;

            movie_name = v.findViewById(R.id.movie_name);
            movie_poster = v.findViewById(R.id.movie_poster);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ComingMovieAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ComingMovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_current_movie, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.movie_name.setText("Ein weiterer Test");


        //Item clicked Event
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMovieDetailsPage = new Intent(mContext, MovieDetails.class);
                mContext.startActivity(startMovieDetailsPage);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

