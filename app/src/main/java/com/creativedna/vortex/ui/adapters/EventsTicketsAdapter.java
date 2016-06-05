package com.creativedna.vortex.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Ticket;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventHeader;
import com.creativedna.vortex.ui.adapters.ViewHolders.TicketsViewHolder;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;


/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class EventsTicketsAdapter extends RecyclerView.Adapter<TicketsViewHolder> implements
        StickyRecyclerHeadersAdapter<EventHeader> {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private Context context;

    public EventsTicketsAdapter(ArrayList<Ticket> tickets, Context context) {
        this.tickets = tickets;
        this.context = context;
    }

    @Override
    public TicketsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TicketsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_single_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(TicketsViewHolder holder, int position) {
        holder.renderView(context, tickets.get(position));
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
//        String date = DataFormatter.formatDate(tickets.get(position).getType());
        holder.renderView(tickets.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }
}
