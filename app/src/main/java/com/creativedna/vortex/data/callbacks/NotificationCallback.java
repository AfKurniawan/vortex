package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.Notifications;

import java.util.ArrayList;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class NotificationCallback {
    private int numFound;
    private ArrayList<Notifications> notifications;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public ArrayList<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notifications> notifications) {
        this.notifications = notifications;
    }
}
