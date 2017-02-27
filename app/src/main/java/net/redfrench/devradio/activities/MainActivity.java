package net.redfrench.devradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.redfrench.devradio.R;
import net.redfrench.devradio.fragments.DaddyFragment;
import net.redfrench.devradio.fragments.DetailsFragment;
import net.redfrench.devradio.model.Station;

public class MainActivity extends AppCompatActivity {

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;  // to make mainActivity acessible from anywhere
    }

    private static MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);  // now have access to mainActivity from anywhere

        FragmentManager fragMgr = getSupportFragmentManager();
        DaddyFragment daddyFragment = (DaddyFragment)fragMgr.findFragmentById(R.id.container_main);  // cast the returned fragment into a DaddyFragment
                                                                                                     // because a regular fragment will be returned

        if (daddyFragment == null) {  // if the fragment has previously loaded, it will be in memory. Otherwise, fragment will be null.
            daddyFragment = DaddyFragment.newInstance("blah", "kah"); // new DaddyFragment will be created in newInstance method
            fragMgr.beginTransaction()  // anytime you work with the FragmentManager, you begin a transaction
                    .add(R.id.container_main, daddyFragment)  // put daddyFragment in the 'container_main' fragment
                    .commit();  // always end by committing
        }
    }

    public void loadDetailsScreen(Station selectedStation) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, new DetailsFragment())
                .addToBackStack(null)
                .commit();
    }
}
