package theoutliers.mock.stages;

public abstract class Stage {

    // Estimated time in minutes
    protected int estimated_time = 0;

    public int getEstimatedTime() {
        return estimated_time;
    }

    public void setEstimatedTime(int estimated_time) {
        this.estimated_time = estimated_time;
    }

    abstract public void update();
}
