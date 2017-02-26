package net.redfrench.devradio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.redfrench.devradio.holders.StationViewHolder;
import net.redfrench.devradio.model.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2/19/17.
 */

//  The adapter will grab all the data from your data source, shove it in the viewHolder, and the viewHolder will go inside the recyclerView
public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder>{  // RecyclerView needs to know the viewHolder you'll use

    private ArrayList<Station> stations;  // <Station> is the model

    public StationsAdapter(ArrayList<Station> stations) {  // constructor
        this.stations = stations;
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

}
