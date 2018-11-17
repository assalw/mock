package theoutliers.mock.stages;

public class ImmigrationToGateStage extends Stage {

    public ImmigrationToGateStage() {
        this.setEstimatedTime(20);
    }

    @Override
    public void update() {
        // Fixed time, no need too update
    }
}
