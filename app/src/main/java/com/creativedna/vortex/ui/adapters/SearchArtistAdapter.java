package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Performer;
import com.creativedna.vortex.ui.adapters.ViewHolders.SearchArtistViewHolder;

import java.util.ArrayList;




/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class SearchArtistAdapter extends RecyclerView.Adapter<SearchArtistViewHolder> {
    private ArrayList<Performer> performers;
    private Context context;

    public SearchArtistAdapter(ArrayList<Performer> performers, Context context) {
        this.performers = performers;
        this.context = context;
    }

    @Override
    public SearchArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchArtistViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_search_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchArtistViewHolder holder, int position) {
        holder.renderView(performers.get(position), context);
    }

    @Override
    public int getItemCount() {
        return performers.size() == 0 ? 0 : performers.size();
    }
}
