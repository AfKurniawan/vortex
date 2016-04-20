package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Venue;
import com.creativedna.vortex.ui.adapters.ViewHolders.SearchVenueViewHolder;

import java.util.ArrayList;



/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class SearchVenueAdapter extends RecyclerView.Adapter<SearchVenueViewHolder> {
    private ArrayList<Venue> venues;
    private Context context;

    public SearchVenueAdapter(ArrayList<Venue> venues, Context context) {
        this.venues = venues;
        this.context = context;
    }

    @Override
    public SearchVenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchVenueViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_search_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchVenueViewHolder holder, int position) {
        holder.renderView(venues.get(position), context);
    }

    @Override
    public int getItemCount() {
        return venues.size() == 0 ? 0 : venues.size();
    }
}
