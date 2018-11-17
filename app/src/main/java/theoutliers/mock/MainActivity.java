package theoutliers.mock;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create Journey
    Journey journey = Journey.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    String[] permissions = {
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_PHONE_STATE };

        // START: Request App permissions
        int requestCode = 1;
        ArrayList<String> permissionPar = new ArrayList<String>();

        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1 ) {
            // Check for unattained permissions
            for (String permission : permissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED ) {
                    permissionPar.add(permission);
                }
            }
        }

        // Check if we need to request permissions
        if (!permissionPar.isEmpty()) {

            // Do the actual request
            requestPermissions(permissionPar.toArray(new String[]{}), requestCode);
        }

        Config.context = getApplicationContext();

        setContentView(R.layout.activity_main);

        journey.setPhoneLocation(new PhoneLocation((LocationManager) Config.context.getSystemService(Context.LOCATION_SERVICE)));

        // TODO: Test flight API

        // TODO: Test travel time
        journey.constructJourney();

        // TODO: Test travel subtimes
    }
}
