package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.activities.EventDetailsActivity;
import com.creativedna.vortex.utils.DataFormatter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class RecommendedViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.ivRecommendedProfile)
    ImageView mRecommendedEventImage;
    @Bind(R.id.tvRecommendedEventTitle)
    TextView mRecommendedEventTitle;
    @Bind(R.id.tvRecommendedEventTime)
    TextView mRecommendedEventTime;
    @Bind(R.id.rlRecommendedEvent)
    RelativeLayout mRecommendedEventLayout;

    public RecommendedViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Context context, final Event event) {
        Picasso.with(context).load(event.getImageUrl()).placeholder(R.drawable.placeholderartist_small).into(mRecommendedEventImage);
        mRecommendedEventTitle.setText(event.getArtist_name());
        String time = DataFormatter.formatDate(event.getEventDateLocal());
        mRecommendedEventTime.setText(time);
        mRecommendedEventLayout.setOnClickListener(new View.OnClickListener() {
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
