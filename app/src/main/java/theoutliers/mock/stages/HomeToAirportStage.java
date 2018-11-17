package theoutliers.mock.stages;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.Duration;
import com.google.maps.model.TravelMode;

import java.io.IOException;

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
        try {
            Log.e("TravelTime", getDurationForRoute("",""));
        }
        catch (Exception e) {

        }

    }

    /**
     Use Google's directions api to calculate the estimated time needed to
     drive from origin to destination by car.

     @param origin The address/coordinates of the origin (see {@link DirectionsApiRequest#origin(String)} for more information on how to format the input)
     @param destination The address/coordinates of the destination (see {@link DirectionsApiRequest#destination(String)} for more information on how to format the input)

     @return The estimated time needed to travel human-friendly formatted
     */
    public String getDurationForRoute(String origin, String destination) throws InterruptedException, ApiException, IOException {

        // - We need a context to access the API
        GeoApiContext geoApiContext = new GeoApiContext.Builder()
                .apiKey(Config.GOOGLE_MAPS_API_KEY)
                .build();


        // - Perform the actual request
        DirectionsResult directionsResult = DirectionsApi.newRequest(geoApiContext)
                .mode(TravelMode.DRIVING)
                .origin(origin)
                .destination(destination)
                .await();

        // - Parse the result
        DirectionsRoute route = directionsResult.routes[0];
        DirectionsLeg leg = route.legs[0];
        Duration duration = leg.duration;
        return duration.humanReadable;
    }
}
