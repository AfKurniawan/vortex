package com.creativedna.vortex.events;

import com.creativedna.vortex.models.Event;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class FavoriteEvent {
    private Event event;

    public FavoriteEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
