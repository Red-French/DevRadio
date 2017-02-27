package net.redfrench.devradio.fragments;

// ~~ STATIONSFRAGMENT WILL HOLD RECYCLERVIEW ~

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.redfrench.devradio.R;
import net.redfrench.devradio.adapters.StationsAdapter;
import net.redfrench.devradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {

    private static final String ARG_STATION_TYPE = "station_type";  // ARG_STATION_TYPE will be the key

    // types of stations
    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    private int stationType;


    public StationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType the radio station type.
     * @return A new instance of fragment StationsFragment.
     */

    // FRAGMENT CONSTRUCTOR (called from DaddyFragmet.java)
    public static StationsFragment newInstance(int stationType) {  // pass in stationType from the main fragment (daddyFragment)
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);  // store key/value pair in bundle (station_type/0, station_type/1, stations_type/2)
        fragment.setArguments(args);  // set stationType
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE); // grab station type from bundle
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stations, container, false);

        // ~ RECYCLER VIEW ~
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycler_stations); // recycler_stations (content_stations_recycler.xml) is the content
        recyclerView.setHasFixedSize(true);  // if the recyclerView is a fixed size, set this to true for increased speed

        // ~ ADAPTER ~
        StationsAdapter adapter;  // the adapter will work directly with the viewHolder (StationsViewHolder)

        if (stationType == STATION_TYPE_FEATURED) {  // stationType was set in onCreate
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        } else if (stationType == STATION_TYPE_RECENT) {
            adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
        } else {
            adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
        }

        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));  // pass space size to go between images

        recyclerView.setAdapter(adapter);

        // ~ LAYOUT MANAGER ~
        // set orientation on the recyclerView
        // RecyclerView is very modularized and needs to be given a layout manager to specify how the child views will be arranged
        // normally, you'd expect 'recyclerView.orientation', but recyclerView is different
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());  // getContext() is the context of the activity
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        return v;  // Inflate the layout for this fragment
    }

}

// add space between images
class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacer;

    public HorizontalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right = spacer;  // 'outRect' is the next rectangle to the right
    }
}