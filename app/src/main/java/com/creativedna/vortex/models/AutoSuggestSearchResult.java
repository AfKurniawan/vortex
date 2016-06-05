package com.creativedna.vortex.models;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class AutoSuggestSearchResult
{
    private ArrayList<Artist> Artists;
    private ArrayList<Event> events;
    private ArrayList<Venue> venues;
    private boolean ArtistExpansion;
    private boolean eventExpansion;
    private boolean venueExpansion;
    private int totalArtistsFound;
    private int totalVenuesFound;
    private int totalEventsFound;

    public ArrayList<Artist> getArtists() {
        return Artists;
    }

    public void setArtists(ArrayList<Artist> Artists) {
        this.Artists = Artists;
    }

    public boolean isArtistExpansion() {
        return ArtistExpansion;
    }

    public void setArtistExpansion(boolean ArtistExpansion) {
        this.ArtistExpansion = ArtistExpansion;
    }

    public boolean isEventExpansion() {
        return eventExpansion;
    }

    public void setEventExpansion(boolean eventExpansion) {
        this.eventExpansion = eventExpansion;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public int getTotalVenuesFound() {
        return totalVenuesFound;
    }

    public void setTotalVenuesFound(int totalVenuesFound) {
        this.totalVenuesFound = totalVenuesFound;
    }

    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }

    public int getTotalArtistsFound() {
        return totalArtistsFound;
    }

    public void setTotalArtistsFound(int totalArtistsFound) {
        this.totalArtistsFound = totalArtistsFound;
    }

    public boolean isVenueExpansion() {
        return venueExpansion;
    }

    public void setVenueExpansion(boolean venueExpansion) {
        this.venueExpansion = venueExpansion;
    }

    public int getTotalEventsFound() {
        return totalEventsFound;
    }

    public void setTotalEventsFound(int totalEventsFound) {
        this.totalEventsFound = totalEventsFound;
    }
}