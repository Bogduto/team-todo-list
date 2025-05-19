package userInterface.Core;

public class Loop implements Runnable
{
    private static final int MAX_FPS = 60;
    private long fpsTimer = 0;
    private int fpsDrawCounter = 0;

    private final Thread timeThread = new Thread(this);
    private static final int SEC_IN_NANO = 1_000_000_000;
    private double delta = 0;
    private long lastTime = System.nanoTime();

    private final MainPanel mainPanel;

    public Loop(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public void start()
    {
        timeThread.start();
    }

    @Override
    public void run()
    {
        long currentTime = 0;
        double updateInterval = (double) SEC_IN_NANO / MAX_FPS;

        while (timeThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / updateInterval;
            fpsTimer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1)
            {
                update();
                render();

                delta = 0;
                fpsDrawCounter++;
            }

            if (fpsTimer >= SEC_IN_NANO)
            {
                System.out.println("FPS: " + fpsDrawCounter);
                fpsDrawCounter = 0;
                fpsTimer = 0;
            }
        }
    }

    private void update()
    {
        mainPanel.update();
    }

    private void render()
    {
        mainPanel.repaint();
    }

}
