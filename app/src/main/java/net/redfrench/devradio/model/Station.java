package net.redfrench.devradio.model;

/**
 * Created by user on 2/21/17.
 */

public class Station {

    final String DRAWABLE = "drawable/";  // root directory for images; all caps indicates a constant/final

    private String stationTitle;
    private String imgUri;


    public Station(String stationTitle, String imgUri) {  // can right-click>Generate>Constructor then choose properties to generate constructor
        this.stationTitle = stationTitle;
        this.imgUri = imgUri;
    }

    public String getStationTitle() {  // can right-click>Generate>Getter or right-click>Refactor>Encapsulate Fields to generate
        return stationTitle;
    }

    public String getImgUri() {  // can right-click>Generate>Getter or right-click>Refactor>Encapsulate Fields to generate
        return DRAWABLE + imgUri;
    }

}
