package oving4;

import java.util.ArrayList;

public class StopWatch {

    private int totalTicks;
    private int lapTicks;
    private int timeTicks;
    private boolean started;
    private boolean stopped;
    private ArrayList<Integer> laps;

    /**
     * Constructor for StopWatch
     */
    public StopWatch() {
        this.totalTicks = 0;
        this.lapTicks = -1;
        this.timeTicks = -1;
        this.started = false;
        this.stopped = false;
        this.laps = new ArrayList<>();
    }

    /**
     * Method to check if this StopWatch has started
     * 
     * @return true if this StopWatch is started, false otherwise
     */
    public boolean isStarted() {
        return this.started;
    }

    /**
     * Method to check if this StopWatch has been stopped once
     * 
     * @return true if this StopWatch has been stopped once, false otherwise
     */
    public boolean isStopped() {
        return this.stopped;
    }

    /**
     * Method to get total ticks to this StopWatch
     * 
     * @return the total ticks
     */
    public int getTicks() {
        return this.totalTicks;
    }

    /**
     * Method to get the time ticks to this StopWatch
     * 
     * @return the time ticks
     */
    public int getTime() {
        return this.timeTicks;
    }

    /**
     * Method to get the the current laptime to this StopWatch
     * 
     * @return the current laptime, -1 if this StopWatch is not started
     */
    public int getLapTime() {
        return this.lapTicks;
    }

    /**
     * Method to get the last laptime to this StopWatch
     * 
     * @return the last lap time, -1 if this StopWatch has no lap times
     */
    public int getLastLapTime() {
        if (this.laps.isEmpty()) {
            return -1;
        } else {
            return this.laps.getLast();
        }
    }

    /**
     * Method to start this StopWatch
     */
    public void start() {
        if (isStarted()) {
            throw new IllegalStateException("Cant start a clock that has been started already");
        }
        this.timeTicks = 0;
        this.lapTicks = 0;
        this.started = true;
    }

    /**
     * Method to stop this StopWatch
     */
    public void stop() {
        lap();
        this.stopped = true;
        this.lapTicks = 0;

    }

    /**
     * Method to stop the current laptime of this StopWatch and start a new
     */
    public void lap() {
        if (!isStarted() || isStopped()) {
            throw new IllegalStateException("Cant lap if watch is not started or stopped");
        }
        laps.add(lapTicks);
        this.lapTicks = 0;
    }

    /**
     * Method to tell this StopWatch how many ticks has passed
     * 
     * @param ticks number of ticks
     */
    public void tick(int ticks) {
        if (ticks < 1) {
            throw new IllegalArgumentException("Ticks must be positive");
        }

        this.totalTicks += ticks;
        if (isStarted() && !isStopped()) {
            this.lapTicks += ticks;
            this.timeTicks += ticks;
        }
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        System.out.println(watch.getLastLapTime());
    }
}
