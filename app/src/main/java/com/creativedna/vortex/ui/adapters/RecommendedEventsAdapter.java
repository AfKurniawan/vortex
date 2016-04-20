package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventHeader;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventItemHolder;
import com.creativedna.vortex.utils.DataFormatter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;


/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class RecommendedEventsAdapter extends RecyclerView.Adapter<EventItemHolder> implements StickyRecyclerHeadersAdapter<EventHeader> {
    private ArrayList<Event> events = new ArrayList<>();
    private Context context;

    public RecommendedEventsAdapter(ArrayList<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public EventItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventItemHolder(context, LayoutInflater.from(parent.getContext()).inflate(R.layout.events_single_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventItemHolder holder, int position) {
        holder.renderView(events.get(position));
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
        return events.size();
    }
}
