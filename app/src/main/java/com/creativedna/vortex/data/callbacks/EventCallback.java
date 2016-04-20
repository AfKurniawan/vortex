package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.Event;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class EventCallback {
    private int numFound;
    private int limit;
    private int offset;
    private ArrayList<Event> events;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
