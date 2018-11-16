package theoutliers.mock.stages;

public abstract class Stage {

    int estimated_time = 0;

    public int getEstimatedTime() {
        return estimated_time;
    }

    abstract public void update();
}
