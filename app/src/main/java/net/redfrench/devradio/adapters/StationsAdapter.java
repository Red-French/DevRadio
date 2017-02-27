package net.redfrench.devradio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.redfrench.devradio.R;
import net.redfrench.devradio.activities.MainActivity;
import net.redfrench.devradio.holders.StationViewHolder;
import net.redfrench.devradio.model.Station;

import java.util.ArrayList;

/**
 * Created by user on 2/19/17.
 */

//  The adapter will grab all the data from your data source, shove it in the viewHolder, and the viewHolder will go inside the recyclerView
public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder>{  // RecyclerView needs to know the viewHolder you'll use

    private ArrayList<Station> stations;  // <Station> is the model

    public StationsAdapter(ArrayList<Station> stations) {  // constructor
        this.stations = stations;  // saves data in the ArrayList, created above
    }

    // pass data into the view holder
    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {  // 'holder' is passing in the card, 'position' is the index
        final Station station = stations.get(position);  // 'stations' is the ArrayList
        holder.updateUI(station); // updateUI() is in StationViewHolder.java

        // load the details screen
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailsScreen(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();  // for each station, onCreateViewHolder() will be called and will create a card/view for it
    }

    // every time a view is needed, this will be called, and a view will be created
    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate the card_station view (parent is the context, which is the recyclerView, which is content_stations_recycler.xml)
        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);  // inflate the view from the parent context

        return new StationViewHolder(stationCard);
    }

}
