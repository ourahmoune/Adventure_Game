package DataGame;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameTimer {
    private ScheduledExecutorService scheduler;
    private long initialDelay;
    private long elapsedTime;

    public GameTimer(long initialDelay) {
        this.initialDelay = initialDelay;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.elapsedTime = 0;
    }

    public void startTimer() {
        scheduler.schedule(this::handleTimeout, initialDelay, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::updateElapsedTime, 0, 1, TimeUnit.SECONDS);
    }

    private void handleTimeout() {
        System.out.println("Time's up! Game over.");
        System.exit(0);
    }

    private void updateElapsedTime() {
        elapsedTime++;
    }

    public long getTimeRemaining() {
        return Math.max(0, initialDelay - elapsedTime);
    }

    public void stopTimer() {
        scheduler.shutdownNow();
    }
}
