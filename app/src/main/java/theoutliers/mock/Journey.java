package theoutliers.mock;

import android.app.Activity;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import theoutliers.mock.stages.AirportToCheckinStage;
import theoutliers.mock.stages.CheckinLineStage;
import theoutliers.mock.stages.CheckinToSecurityStage;
import theoutliers.mock.stages.HomeToAirportStage;
import theoutliers.mock.stages.ImmigrationLineStage;
import theoutliers.mock.stages.ImmigrationToGateStage;
import theoutliers.mock.stages.SecurityLineStage;
import theoutliers.mock.stages.SecurityToImmigration;
import theoutliers.mock.stages.Stage;

public class Journey {

    LinkedList<Stage> stages = new LinkedList<Stage>();

    PhoneLocation phoneLocation = null; //new PhoneLocation();

    String travelTime = "";

    Timer updateTimer = null;

    // Singleton thread safe
    private static final Journey SINGLE_INSTANCE = new Journey();
    private Journey() {}
    public synchronized static Journey getInstance() {
        return SINGLE_INSTANCE;
    }

    public void constructJourney(){
        // New update timer
        updateTimer = new Timer();

        // Build the Journey stages
        stages.add(new HomeToAirportStage(phoneLocation));
        stages.add(new AirportToCheckinStage());
        stages.add(new CheckinLineStage());
        stages.add(new CheckinToSecurityStage());
        stages.add(new SecurityLineStage());
        stages.add(new SecurityToImmigration());
        stages.add(new ImmigrationLineStage());
        stages.add(new ImmigrationToGateStage());

        // Start update timer
        updateTimer.scheduleAtFixedRate(new StageUpdateTask(), 0, 2000);
    }

    public void clearJourney(){
        // Stop update timer
        updateTimer.cancel();
        updateTimer = null;

        // Clear journey
        stages.clear();
    }

    // Update Journey stages called by Update Timer
    public synchronized void updateStages(){
        for(Stage stage : stages) {
            stage.update();
        }

        // update total time as well
        this.totalTime();
    }

    public int totalTime(){
        int totalTime = 0;
        for(Stage stage : stages) {
            totalTime += stage.getEstimatedTime();
        }

        Log.e("TRAVEL_TIMES", "total_travel_time: " + totalTime);

        return totalTime;
    }
}
