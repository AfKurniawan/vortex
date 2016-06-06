package com.creativedna.vortex.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan Lamtoo on 04/15/2016.
 */
public class Artist implements Serializable {

    private String id;
    private String category_name;
    private String name;
    private String description;
    private String descriptionSource;
//    private String familiarity;
//    private String hotttnesss;
//    private String discovery;
    private ArrayList<String> genres ;
    private Urls urls;
    private ArrayList<Image> images;


    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setCategory_name(String name) {
        this.category_name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The descriptionSource
     */
    public String getDescriptionSource() {
        return descriptionSource;
    }

    /**
     *
     * @param descriptionSource
     * The description_source
     */
    public void setDescriptionSource(String descriptionSource) {
        this.descriptionSource = descriptionSource;
    }



    /**
     *
     * @return
     * The genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     * The genres
     */
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     *
     * @return
     * The urls
     */
    public Urls getUrls() {
        return urls;
    }

    /**
     *
     * @param urls
     * The urls
     */
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    /**
     *
     * @return
     * The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }


//    private int id;
//    private String name;
//    private String description;
//    private String description_source;
//    private ArrayList<Image> images;
//    private ArrayList<String> genres;
//    private double familiarity;
//    private double hotttnesss;
//    private double discovery;
//    private Urls urls;
    private boolean is_favorite = false;
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

//    public double getFamiliarity() {
//        return familiarity;
//    }
//
//    public void setFamiliarity(double familiarity) {
//        this.familiarity = familiarity;
//    }
//
//    public double getHotttnesss() {
//        return hotttnesss;
//    }
//
//    public void setHotttnesss(double hotttnesss) {
//        this.hotttnesss = hotttnesss;
//    }
//
//    public double getDiscovery() {
//        return discovery;
//    }
//
//    public void setDiscovery(double discovery) {
//        this.discovery = discovery;
//    }
//
//    public ArrayList<String> getGenres() {
//        return genres;
//    }
//
//    public void setGenres(ArrayList<String> genres) {
//        this.genres = genres;
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
//        return name;
//    }
//
//    public void setCategory_name(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getDescription_source() {
//        return description_source;
//    }
//
//    public void setDescription_source(String description_source) {
//        this.description_source = description_source;
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
//    public Urls getUrls() {
//        return urls;
//    }
//
//    public void setUrls(Urls urls) {
//        this.urls = urls;
//    }
}
