package theoutliers.mock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create Journey
    Journey journey = Journey.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Config.context = getApplicationContext();

        setContentView(R.layout.activity_main);


        // TODO: Test flight API

        // TODO: Test travel time
        journey.constructJourney();

        // TODO: Test travel subtimes

    }
}
