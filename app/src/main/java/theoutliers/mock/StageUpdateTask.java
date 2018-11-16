package theoutliers.mock;

import java.util.TimerTask;

public class StageUpdateTask extends TimerTask
{
    public void run()
    {
        Journey.getInstance().updateStages();
    }
}