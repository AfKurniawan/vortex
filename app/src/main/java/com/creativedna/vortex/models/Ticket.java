package com.creativedna.vortex.models;

import java.io.Serializable;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class Ticket implements Serializable {

    private String amount;
    private String totalAvailable;
    private String type;

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    private String currencyCode;



    private String event_id;
    private String ticket_id;
    private String deadline;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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


}
