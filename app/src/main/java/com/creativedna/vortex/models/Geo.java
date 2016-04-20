package com.creativedna.vortex.models;

import java.io.Serializable;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class Geo implements Serializable {
    private int id;
    private String name;
    private String url;
    private String webURI;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebURI() {
        return webURI;
    }

    public void setWebURI(String webURI) {
        this.webURI = webURI;
    }
}
