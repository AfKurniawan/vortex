package com.creativedna.vortex.events;

import com.creativedna.vortex.models.Artist;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class FavoriteArtist {
    private Artist artist;

    public FavoriteArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
