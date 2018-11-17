package theoutliers.mock.stages;

public class SecurityToImmigration extends Stage {

    public SecurityToImmigration() {
        this.setEstimatedTime(5);
    }

    @Override
    public void update() {
        // Fixed time, no need too update
    }
}
