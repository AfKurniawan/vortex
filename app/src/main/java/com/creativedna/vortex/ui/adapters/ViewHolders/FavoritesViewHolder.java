package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.ui.activities.EventDetailsActivity;
import com.creativedna.vortex.ui.fragments.TabFavoritesFragment;
import com.creativedna.vortex.utils.DataFormatter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class FavoritesViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.ivEventsSingleEvent_favorite_image)
    ImageView ivFavorite;
    @Bind(R.id.ivEventImage)
    ImageView eventImage;
    @Bind(R.id.tvEventTitle)
    TextView eventTitle;
    @Bind(R.id.tvEventDesc)
    TextView eventDesc;
    @Bind(R.id.tvEventTime)
    TextView eventTime;
    @Bind(R.id.tvEventVenue)
    TextView eventVenue;
    @Bind(R.id.tvEventCity)
    TextView eventCity;
    @Bind(R.id.ivShare)
    ImageView shareEvent;

    View itemView;

    public FavoritesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.itemView = itemView;
    }

    public void renderView(@NonNull final Event event, final Context context, final TabFavoritesFragment favoriteEventListener) {
        eventTitle.setText(event.getArtist_name());
        eventDesc.setText(event.getVenue().getName());
        Picasso.with(context).load(event.getImageUrl()).placeholder(R.drawable.placeholder).into(eventImage);
        eventTime.setText(event.getEventDateLocal());
        eventVenue.setText(event.getVenue().getName());
        String time = DataFormatter.formatTime(event.getEventDateLocal());
        eventTime.setText(time);
        // eventCity.setText(event.getVenue().getCity());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("event", event);
                context.startActivity(intent);
            }
        });

        String performers = "";

        if (event.getArtists() != null) {
            for (Artist performer : event.getArtists()) {
                performers += performer.getName() + ", ";
            }
        }
        eventDesc.setText(performers);

        ivFavorite.setImageDrawable(context.getResources().getDrawable(R.drawable.starred_star));
        ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (event.is_favorite()) {
                    // if (event.is_favorite()){
                    favoriteEventListener.unFavorite(context, event);
                    ivFavorite.setTag("unfavorite");
                    Toast.makeText(context, "Removed from Favorites", Toast.LENGTH_LONG).show();
                    ivFavorite.setTag("favorite");
                    event.setIs_favorite(false);
                    ivFavorite.setImageDrawable(context.getResources().getDrawable(R.drawable.star_unstarred));

                }
               // EventBus.getDefault().post(new FavoriteEvent());
            }
        });
    }
}
