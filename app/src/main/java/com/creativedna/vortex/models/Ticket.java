package com.creativedna.vortex.models;

import java.io.Serializable;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class Ticket implements Serializable {

    private String amount;
    private String totalAvailable;
    private String type;
    private String currencyCode;
    private int eventId;
    private int ticketId;
    private String dealine;

    public String getDealine() {
        return dealine;
    }

    public void setDealine(String dealine) {
        this.dealine = dealine;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(String totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
