package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.Event;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class EventCallback {
//    private int numFound;
//    private int limit;
//    private int offset;
//    private ArrayList<Event> events;

//    public int getNumFound() {
//        return numFound;
//    }

//    public void setNumFound(int numFound) {
//        this.numFound = numFound;
//    }

//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }
//
//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.offset = offset;
//    }
//
//    public ArrayList<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(ArrayList<Event> events) {
//        this.events = events;
//    }




    private int numFound;
    private Object limit;
    private Object offset;
    private ArrayList<Event> events;

    /**
     *
     * @return
     * The numFound
     */
    public int getNumFound() {
        return numFound;
    }

    /**
     *
     * @param numFound
     * The numFound
     */
    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    /**
     *
     * @return
     * The limit
     */
    public Object getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     * The limit
     */
    public void setLimit(Object limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     * The offset
     */
    public Object getOffset() {
        return offset;
    }

    /**
     *
     * @param offset
     * The offset
     */
    public void setOffset(Object offset) {
        this.offset = offset;
    }

    /**
     *
     * @return
     * The events
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     *
     * @param events
     * The events
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

}
