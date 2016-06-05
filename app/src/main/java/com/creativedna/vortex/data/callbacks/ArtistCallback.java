package com.creativedna.vortex.data.callbacks;

import com.creativedna.vortex.models.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aron on 10/27/2015.
 */
public class ArtistCallback {

    private int numFound;
    private Object limit;
    private Object offset;
    private List<Artist> artists;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


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
     * The artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     *
     * @param artists
     * The artists
     */
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
