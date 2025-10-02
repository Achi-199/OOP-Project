/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */

/**
 * Abstract base class representing a space travel target.
 * Provides common attributes and operations for waypoints.
 */
public abstract class SpaceWaypoint {
    protected final String label;
    protected final int targetDistance;
    protected int travelledUnits = 0;
    protected final int fuelRate;
    protected final int scientificValue;
    protected int observationProgress = 0;

    /**
     * Constructs a waypoint.
     *
     * @param label the name of the destination
     * @param targetDistance the total distance to the destination
     * @param fuelRate the fuel consumed per 100 distance units
     * @param scientificValue value of this destination for research
     */
    public SpaceWaypoint(String label, int targetDistance, int fuelRate, int scientificValue) {
        this.label = label;
        this.targetDistance = targetDistance;
        this.fuelRate = fuelRate;
        this.scientificValue = scientificValue;
    }

    /**
     * Returns the remaining distance to reach this waypoint.
     *
     * @return remaining distance
     */
    public abstract int remainingDistance();

    /**
     * Checks if the destination has been reached.
     *
     * @return true if arrived, false otherwise
     */
    public abstract boolean hasArrived();

    /**
     * Advances progress towards the waypoint by the given units.
     *
     * @param units the amount of distance progressed
     */
    public abstract void updateProgress(int units);

    public double getCompletionPercentage() {
        return (100.0 * travelledUnits) / targetDistance;
    }

    public double getObservationPercentage() {
        return (100.0 * observationProgress) / targetDistance;
    }

    public int getScientificValue() {
        return scientificValue;
    }

    public int getFuelRate() {
        return fuelRate;
    }

    public String getLabel() {
        return label;
    }
}

