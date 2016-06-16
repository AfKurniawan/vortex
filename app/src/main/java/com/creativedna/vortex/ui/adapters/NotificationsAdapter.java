package com.creativedna.vortex.ui.adapters;

        import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Notifications;
import com.creativedna.vortex.ui.adapters.ViewHolders.EventHeader;
import com.creativedna.vortex.ui.adapters.ViewHolders.NotificationsViewHolder;
import com.creativedna.vortex.utils.DataFormatter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;


/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD on 04/15/2016.
 */
public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsViewHolder> implements
        StickyRecyclerHeadersAdapter<EventHeader> {
    private ArrayList<Notifications> notifications;
    private Context context;

    public NotificationsAdapter(ArrayList<Notifications> events, Context context) {
        this.notifications = events;
        this.context = context;

    }

    @Override
    public NotificationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotificationsViewHolder(context, LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NotificationsViewHolder holder, int position) {
        holder.renderView(notifications.get(position));

    }


    @Override
    public long getHeaderId(int position) {
        String date = DataFormatter.formatDate(notifications.get(position).getDateCreated());
        String nextDate;
        while (position > notifications.size()) {
            nextDate = DataFormatter.formatDate(notifications.get(position + 1).getDateCreated());
            if (date.equals(nextDate)) {
                return position;
            }
        }

        return position;
    }

    @Override
    public EventHeader onCreateHeaderViewHolder(ViewGroup parent) {
        return new EventHeader(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_sticky_header, parent, false));
    }

    @Override
    public void onBindHeaderViewHolder(EventHeader holder, int position) {
        String date = DataFormatter.formatDate(notifications.get(position).getDateCreated());
        holder.renderView(date);
    }

    @Override
    public int getItemCount() {
        return notifications.size() == 0 ? 0 : notifications.size();
    }
}
