package net.redfrench.devradio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.redfrench.devradio.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaddyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaddyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DaddyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DaddyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DaddyFragment newInstance(String param1, String param2) {
        DaddyFragment fragment = new DaddyFragment();
        Bundle args = new Bundle();  // a bundle stores data
        args.putString(ARG_PARAM1, param1);  // ARG_PARAM1 is defined above
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);  // initialization; arguments are retrieved below in onCreate()
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_daddy, container, false);  // inflate 'fragment_daddy.xml'

        FragmentManager fm = getActivity().getSupportFragmentManager();  // getSupportFragmentManager() is a method of Activity, so since
                                                                         // this is a fragment, must first get the context (activity)
        // no 'null' check because want data to load each time; therefore need the view destroyed and re-created each time
        StationsFragment stationsFragment1;
        StationsFragment stationsFragment2;  // STATIONSFRAGMENT WILL HOLD RECYCLERVIEW
        StationsFragment stationsFragment3;

        stationsFragment1 = StationsFragment.newInstance(StationsFragment.STATION_TYPE_FEATURED);  // fragment constructor called
        fm.beginTransaction()
            .add(R.id.container_top_row, stationsFragment1)
            .commit();

        stationsFragment2 = StationsFragment.newInstance(StationsFragment.STATION_TYPE_RECENT);
        fm.beginTransaction()
                .add(R.id.container_middle_row, stationsFragment2)
                .commit();

        stationsFragment3 = StationsFragment.newInstance(StationsFragment.STATION_TYPE_PARTY);
        fm.beginTransaction()
                .add(R.id.container_bottom_row, stationsFragment3)
                .commit();

        // Inflate the layout for this fragment
        return v;
    }

}
