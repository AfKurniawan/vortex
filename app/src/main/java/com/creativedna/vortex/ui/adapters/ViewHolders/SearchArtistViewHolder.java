package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.colintmiller.simplenosql.NoSQL;
import com.colintmiller.simplenosql.NoSQLEntity;
import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.Performer;
import com.creativedna.vortex.ui.activities.ArtistActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class SearchArtistViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.ivSearch_favorite)
    ImageView favoriteImage;
    @Bind(R.id.tvSearch_title)
    TextView searchTitle;
    @Bind(R.id.ivSearch_with_shows)
    ImageView searchWithShow;

    public SearchArtistViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Artist performers, final Context context) {
        searchTitle.setText(performers.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArtistActivity.class);
                intent.putExtra("artist", performers);
                context.startActivity(intent);
            }
        });

//        if (performers.getEventCount() > 0) {
            searchWithShow.setVisibility(ImageView.VISIBLE);
//        }

        // favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.starred_star));
        favoriteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!performers.is_favorite()) {
                    // if (event.is_favorite()){
                    favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.starred_star));
                    favoriteImage.setTag("favorite");
                    Toast.makeText(context, "Added to Favorites", Toast.LENGTH_LONG).show();
                    favoriteImage.setTag("favorite");
                    performers.setIs_favorite(true);
                    favorite(performers, context);
                    //save(performers, context);
                } else {
                    favoriteImage.setImageDrawable(context.getResources().getDrawable(R.drawable.star_unstarred));
                    Toast.makeText(context, "Removed from Favorites", Toast.LENGTH_LONG).show();
                    favoriteImage.setTag("unfavorite");
                    performers.setIs_favorite(false);
                    unfavorite(performers, context);
                }
              //  EventBus.getDefault().post(new FavoriteEvent(even));
            }
        });
    }

    public void favorite(Artist performer, Context context) {
        NoSQLEntity<Artist> entity = new NoSQLEntity<Artist>("my_artists", performer.getId() + "");
        entity.setData(performer);
        NoSQL.with(context).using(Artist.class).save(entity);
    }

    public void unfavorite(Artist performers, Context context) {
        NoSQL.with(context).using(Performer.class)
                .bucketId("my_artists")
                .entityId(performers.getId() + "")
                .delete();
    }

}
