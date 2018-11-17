package theoutliers.mock.stages;

public class CheckinToSecurityStage extends Stage {

    public CheckinToSecurityStage() {
        this.setEstimatedTime(20);
    }

    @Override
    public void update() {
        // Fixed time, no need too update

        // Test
        this.estimated_time -= 1;
    }
}
