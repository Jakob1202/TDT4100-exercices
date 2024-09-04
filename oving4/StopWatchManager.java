package oving4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {
    private Map<String, StopWatch> stopWatches;

    /**
     * Constructor for StopWatchManager
     */
    public StopWatchManager() {
        this.stopWatches = new HashMap<>();
    }

    /**
     * Method to add a new stopWatch to this stopWatchManager
     * 
     * @param name the name to the new stopWatch
     * @return the name to the new stopWatch
     */
    public StopWatch newStopWatch(String name) {
        this.stopWatches.put(name, new StopWatch());
        return stopWatches.get(name);
    }

    /**
     * Method to remove a stopWatch from this stopWatchManager
     * 
     * @param name the name to the stopWatch
     */
    public void removeStopWatch(String name) {
        this.stopWatches.remove(name);
    }

    /**
     * Method to tell all stopWatches in this stopWatchManager how many ticks has
     * been passed
     * 
     * @param ticks number of ticks
     */
    public void tick(int ticks) {
        for (StopWatch stopWatch : this.stopWatches.values()) {
            stopWatch.tick(ticks);
        }
    }

    /**
     * Method to get a stopWatch from this stopWatchManger
     * 
     * @param name the name to the stopWatch
     * @return the stopWatch
     */
    public StopWatch getStopWatch(String name) {
        return this.stopWatches.get(name);
    }

    /**
     * Method to get all the stopWatches from this stopWatchManager
     * 
     * @return all the stopWatches
     */
    public Collection<StopWatch> getAllWatches() {
        return this.stopWatches.values();
    }

    /**
     * Method to get all the started stopWatches to this stopWatchManager
     * 
     * @return all the stopWatches
     */
    public Collection<StopWatch> getStartedWatches() {
        Collection<StopWatch> startedStopWatches = new ArrayList<>();
        for (StopWatch stopWatch : this.stopWatches.values()) {
            if (stopWatch.isStarted()) {
                startedStopWatches.add(stopWatch);
            }
        }
        return startedStopWatches;
    }

    /**
     * Method to get all the stopped stopWatches to this stopWatchManager
     * 
     * @return all the stopWatches
     */
    public Collection<StopWatch> getStoppedWatches() {
        Collection<StopWatch> stoppedStopWatches = new ArrayList<>();
        for (StopWatch stopWatch : this.stopWatches.values()) {
            if (stopWatch.isStopped()) {
                stoppedStopWatches.add(stopWatch);
            }
        }
        return stoppedStopWatches;
    }

}
