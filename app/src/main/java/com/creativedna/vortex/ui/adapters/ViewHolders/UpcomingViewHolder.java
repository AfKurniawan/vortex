package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.activities.EventDetailsActivity;
import com.creativedna.vortex.utils.DataFormatter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class UpcomingViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.tvUpcoming_event_date)
    TextView mUpcomingEventDate;
    @Bind(R.id.tvUpcoming_event_title)
    TextView mUpcomingEventTitle;
    @Bind(R.id.tvUpcoming_event_venue)
    TextView mUpcomingEventVenue;
    @Bind(R.id.rlUpcomingEvent)
    RelativeLayout mUpcomingEventlayout;

    public UpcomingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Context context, final Event event) {
        mUpcomingEventTitle.setText(event.getArtist_name());
        mUpcomingEventVenue.setText(event.getVenue().getName());
        mUpcomingEventDate.setText(DataFormatter.formatDate(event.getEventDateLocal()));
        mUpcomingEventlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("event", event);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
}
