package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventHeader;
import com.creativedna.vortex.ui.adapters.ViewHolders.FavoritesViewHolder;
import com.creativedna.vortex.ui.fragments.TabFavoritesFragment;
import com.creativedna.vortex.utils.DataFormatter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;



/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD on 10/28/2015.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder> implements StickyRecyclerHeadersAdapter<EventHeader> {
    private ArrayList<Event> events;
    private Context context;
    private TabFavoritesFragment tabFavoritesFragment;

    public FavoritesAdapter(ArrayList<Event> events, Context context, TabFavoritesFragment tabFavoritesFragment) {
        this.events = events;
        this.context = context;
        this.tabFavoritesFragment = tabFavoritesFragment;
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoritesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.events_single_event, parent, false));
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder holder, int position) {
        if (events.get(position) != null) {
            holder.renderView(events.get(position), context, tabFavoritesFragment);
        } else {
            Log.d("Favorites error: ", "null event");
        }
    }


    @Override
    public long getHeaderId(int position) {
        return position;
    }

    @Override
    public EventHeader onCreateHeaderViewHolder(ViewGroup parent) {
        return new EventHeader(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_sticky_header, parent, false));
    }

    @Override
    public void onBindHeaderViewHolder(EventHeader holder, int position) {
        String date = DataFormatter.formatDate(events.get(position).getEventDateLocal());
        holder.renderView(date);
    }

    @Override
    public int getItemCount() {
        return events.size() == 0 ? 0 : events.size();
    }

}
