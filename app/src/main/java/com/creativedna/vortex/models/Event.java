package com.creativedna.vortex.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class Event implements Serializable {

    private boolean is_favorite = false;


    private String id;
    private String name;
    private String eventDateLocal;
    private Venue venue;
    private String distance;
    private ArrayList<Image> images;
    private String imageUrl;
    private String venueId;
    private ArrayList<Ticket> tickets;
    private ArrayList<Artist> artists;

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The venueId
     */
    public String getVenueId() {
        return venueId;
    }

    /**
     * @param venueId The venue_id
     */
    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }


    /**
     * @return The eventDateLocal
     */
    public String getEventDateLocal() {
        return eventDateLocal;
    }

    /**
     * @param eventDateLocal The eventDateLocal
     */
    public void setEventDateLocal(String eventDateLocal) {
        this.eventDateLocal = eventDateLocal;
    }

    /**
     * @return The distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     * @param distance The distance
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * @return The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return The artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * @param artists The artists
     */
    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    /**
     * @return The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    /**
     * @return The venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * @param venue The venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }


    //    public TicketUrls getTicketUrls() {
//        return ticketUrls;
//    }
//
//    public void setTicketUrls(TicketUrls ticketUrls) {
//        this.ticketUrls = ticketUrls;
//    }
//
//    public ArrayList<Performer> getPerformers() {
//        return performers;
//    }
//
//    public void setPerformers(ArrayList<Performer> performers) {
//        this.performers = performers;
//    }
//
//    public Event() {
//    }
//
//    public String getEventDateUTC() {
//        return eventDateUTC;
//    }
//
//    public void setEventDateUTC(String eventDateUTC) {
//        this.eventDateUTC = eventDateUTC;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getCategory_name() {
//        return artist_name;
//    }
//
//    public void setCategory_name(String artist_name) {
//        this.artist_name = artist_name;
//    }
//
//    public String getEventDateLocal() {
//        return eventDateLocal;
//    }
//
//    public void setEventDateLocal(String eventDateLocal) {
//        this.eventDateLocal = eventDateLocal;
//    }
//
//    public Venue getVenue() {
//        return venue;
//    }
//
//    public void setVenue(Venue venue) {
//        this.venue = venue;
//    }
//
//    public Ticket getTicketInfo() {
//        return ticketInfo;
//    }
//
//    public void setTicketInfo(Ticket ticketInfo) {
//        this.ticketInfo = ticketInfo;
//    }
//
//    public void setDistance(long distance) {
//        this.distance = distance;
//    }
//
//    public ArrayList<Image> getImages() {
//        return images;
//    }
//
//    public void setImages(ArrayList<Image> images) {
//        this.images = images;
//    }
//
//    public ArrayList<Category> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(ArrayList<Category> categories) {
//        this.categories = categories;
//    }
//
//    public double getDistance() {
//        return distance;
//    }
//
//    public void setDistance(double distance) {
//        this.distance = distance;
//    }
//
    public boolean is_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
