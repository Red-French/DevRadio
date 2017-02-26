package net.redfrench.devradio.services;

import net.redfrench.devradio.model.Station;

import java.util.ArrayList;

/**
 * Created by user on 2/25/17.
 */
public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {

    }

    public ArrayList<Station> getFeaturedStations() {

        // hardcoded here, but would do API request here
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel", "flightplanmusic"));  // title, image in drawable
        list.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kid Jams (Music for Children)", "kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStations() {

        // hardcoded here, but would do API request here
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel", "flightplanmusic"));  // title, image in drawable
        list.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kid Jams (Music for Children)", "kidsmusic"));

        return list;
    }

    public ArrayList<Station> getPartyStations() {

        // hardcoded here, but would do API request here
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for Travel", "flightplanmusic"));  // title, image in drawable
        list.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kid Jams (Music for Children)", "kidsmusic"));

        return list;
    }

}
