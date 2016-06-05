package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.Event;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class ArtistEventCallback {

    private int numFound;
    private String limit;
    private String offset;
    private ArrayList<Event> events;


    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
