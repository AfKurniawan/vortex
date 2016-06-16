package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.EventTicket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class TicketsCallback {

    private int numFound;
    private List<EventTicket> eventTickets = new ArrayList<>();

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
     * The eventTickets
     */
    public List<EventTicket> getEventTickets() {
        return eventTickets;
    }

    /**
     *
     * @param eventTickets
     * The event_tickets
     */
    public void setEventTickets(List<EventTicket> eventTickets) {
        this.eventTickets = eventTickets;
    }
}
