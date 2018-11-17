package theoutliers.mock;

import android.provider.ContactsContract;

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

    Timer updateTimer = new Timer();

    // Singleton thread safe
    private static final Journey SINGLE_INSTANCE = new Journey();
    private Journey() {}
    public synchronized static Journey getInstance() {
        return SINGLE_INSTANCE;
    }

    public void constructJourney(){
        // Stop update timer
        // updateTimer.cancel();

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
        // updateTimer.scheduleAtFixedRate(new StageUpdateTask(), 0, 2000);
    }

    public void clearJourney(){
        // Stop update timer
        // updateTimer.cancel();

        // Clear journey
        stages.clear();
    }

    // Update Journey stages called by Update Timer
    public synchronized void updateStages(){
        for(Stage stage : stages) {
            stage.update();
        }
    }

    public int totalTime(){
        int totalTime = 0;
        for(Stage stage : stages) {
            totalTime += stage.getEstimatedTime();
        }
        return totalTime;
    }
}
