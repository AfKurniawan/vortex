package com.creativedna.vortex.config;

import com.creativedna.vortex.models.Artist;
import com.creativedna.vortex.models.Event;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class TestData {
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<Artist> artists = new ArrayList<>();

    public static ArrayList<Artist> getArtists() {
        for (int i = 0; i < 10; i++) {
            Artist artist = new Artist();
            artist.setArtist_name("Nicki");
            artist.setId(i+"");
            artist.setDescription("Boss lady");
            artist.setDescriptionSource("New yotk times");
//            artist.setDiscovery(15.15);
//            artist.setFamiliarity(10.024);
//            artist.setHotttnesss(10.00);
            artists.add(artist);
        }
        return artists;
    }

    public ArrayList<Event> getEvents() {
        return events;

    }
}
