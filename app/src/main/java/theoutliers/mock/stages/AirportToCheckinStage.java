package theoutliers.mock.stages;

public class AirportToCheckinStage extends Stage {

    public AirportToCheckinStage (){
        this.setEstimatedTime(10);
    }

    @Override
    public void update() {
        // Fixed time, no need to update
    }

}
