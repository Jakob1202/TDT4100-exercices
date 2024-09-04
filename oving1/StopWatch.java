package oving1;

import java.util.ArrayList;

public class StopWatch {

    private int totalTicks;
    private int lapTicks;
    private int timeTicks;
    private boolean started;
    private boolean stopped;
    private ArrayList<Integer> laps;

    public StopWatch() {
        this.totalTicks = 0;
        this.lapTicks = -1;
        this.timeTicks = -1;
        this.started = false;
        this.stopped = false;
        this.laps = new ArrayList<>();
    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public int getTicks() {
        return this.totalTicks;
    }

    public int getTime() {
        return this.timeTicks;
    }

    public int getLapTime() {
        return this.lapTicks;
    }

    public int getLastLapTime() {
        if (this.laps.isEmpty()) {
            return -1;
        } else {
            return this.laps.getLast();
        }
    }

    public void start() {
        this.timeTicks = 0;
        this.lapTicks = 0;
        this.started = true;
    }

    public void stop() {
        this.stopped = true;
        lap();
        this.lapTicks = 0;

    }

    public void lap() {
        laps.add(lapTicks);
        this.lapTicks = 0;
    }

    public void tick(int ticks) {
        this.totalTicks += ticks;
        if (isStarted() && !isStopped()) {
            this.lapTicks += ticks;
            this.timeTicks += ticks;
        }
    }

}
