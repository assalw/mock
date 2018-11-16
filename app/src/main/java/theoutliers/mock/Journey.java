package theoutliers.mock;

import java.util.LinkedList;

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

    // Singleton
    private static final Journey SINGLE_INSTANCE = new Journey();
    private Journey() {}
    public static Journey getInstance() {
        return SINGLE_INSTANCE;
    }

    public void constructJourney(){
    // TODO: I do not think we need any parameters here

    // Build the Journey stages
    stages.add(new HomeToAirportStage());
    stages.add(new AirportToCheckinStage());
    stages.add(new CheckinLineStage());
    stages.add(new CheckinToSecurityStage());
    stages.add(new SecurityLineStage());
    stages.add(new SecurityToImmigration());
    stages.add(new ImmigrationLineStage());
    stages.add(new ImmigrationToGateStage());

    // TODO: Start update timer

    }

    public void clearJourney(){
    // TODO: Stop update timer

        stages.clear();
    }



    public int totalTime(){
        int totalTime = 0;
        for(Stage stage : stages) {
            totalTime += stage.getEstimatedTime();
        }
        return totalTime();
    }
}
