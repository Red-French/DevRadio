package net.redfrench.devradio.holders;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.redfrench.devradio.R;
import net.redfrench.devradio.model.Station;

/**
 * Created by user on 2/19/17.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {

    private ImageView mainImage;
    private TextView titleTextView;


    public StationViewHolder(View itemView) {  // constructor (a java entry point that's called when you create a new instance of this class)

        super(itemView);

        this.mainImage = (ImageView)itemView.findViewById(R.id.main_image);
        this.titleTextView = (TextView)itemView.findViewById(R.id.main_text);
    }

    // called when the UI needs to be updated
    public void updateUI(Station station) {  // every time a new view (card_station.xml) hits the screen, pass the station into it
        // change image
        String uri = station.getImgUri();  // getImgUri() is in the model (Station.java)
        int resource = mainImage.getResources().getIdentifier(uri, null, mainImage.getContext().getPackageName());  // can only get the package
                                                                                                            // from the mainActivity context
                                                                                                            // which is why context is gotten
                                                                                                            // from mainImage
        mainImage.setImageResource(resource);  // setImageResource() takes an ID
        titleTextView.setText(station.getStationTitle());
    }
}
