package theoutliers.mock.stages;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import theoutliers.mock.Config;
import theoutliers.mock.PhoneLocation;

public class HomeToAirportStage extends Stage {

    PhoneLocation phoneLocation = null;

    public HomeToAirportStage(PhoneLocation phoneLocation) {
        this.phoneLocation = phoneLocation;

        // TODO: Setup travel API
    }

    @Override
    public void update(){

    }
}
