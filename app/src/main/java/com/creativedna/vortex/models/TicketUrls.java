package com.creativedna.vortex.models;

import java.io.Serializable;

/**
 *  Created by Bryan Lamtoo on 04/15/2016.
 */
public class TicketUrls implements Serializable {
    private String url;
    private String source;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
