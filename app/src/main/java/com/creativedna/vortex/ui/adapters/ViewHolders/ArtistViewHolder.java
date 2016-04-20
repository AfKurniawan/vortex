package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.creativedna.vortex.R;
import com.creativedna.vortex.models.Artist;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class ArtistViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.rlArtistLayout)
    RelativeLayout artistLayout;

    @Bind(R.id.tvArtistName)
    TextView tvName;

    @Bind(R.id.ivArtistPpic)
    ImageView ivProfilePic;

    @Bind(R.id.tvArtistNameInitial)
    TextView tvInitial;

    @Bind(R.id.ivArtistWithShows)
    ImageView ivWithShows;

    Context context;

    @OnClick(R.id.rlArtistLayout)
    void loadArtist() {

    }

    public ArtistViewHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.context = context;
    }

    public void render(Artist artist){
        if(artist.getImages() != null) {
            if(artist.getImages().size() > 0 ) {
                Picasso.with(context).load(artist.getImages().get(0).getUrl()).into(ivProfilePic);
            }
        }


        ivWithShows.setVisibility(View.GONE);
        tvName.setText(artist.getName());

    }
}
