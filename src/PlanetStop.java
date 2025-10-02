/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Concrete implementation of a space travel destination.
 * <p>
 * A PlanetStop is a specific destination on the shuttle's journey,
 * characterized by its distance, fuel consumption rate, and scientific value.
 * It tracks how much distance has been traveled and how much scientific
 * observation has been performed during the approach.
 * </p>
 * 
 * @author Achi
 */
public class PlanetStop extends SpaceWaypoint {

    /**
     * Constructs a new PlanetStop with the given attributes.
     *
     * @param label            the name of the destination
     * @param distance         the total distance from Earth to this destination
     * @param fuelRate         fuel consumption rate per 100 units of travel
     * @param scientificValue  value assigned for exploration/scientific research
     */
    public PlanetStop(String label, int distance, int fuelRate, int scientificValue) {
        super(label, distance, fuelRate, scientificValue);
    }

    /**
     * Calculates how much further is needed to reach this stop.
     *
     * @return the remaining distance from current progress to the target
     */
    @Override
    public int remainingDistance() {
        return targetDistance - travelledUnits;
    }

    /**
     * Checks if the shuttle has reached this planet.
     *
     * @return true if travel progress equals or exceeds total distance
     */
    @Override
    public boolean hasArrived() {
        return travelledUnits >= targetDistance;
    }

    /**
     * Advances travel progress and accumulates scientific observation.
     * Caps both values at the destination's distance limit.
     *
     * @param units the number of units traveled in this advancement
     */
    @Override
    public void updateProgress(int units) {
        travelledUnits += units;
        observationProgress += units / 2; // Simulate observation work

        if (travelledUnits > targetDistance) {
            travelledUnits = targetDistance;
        }
        if (observationProgress > targetDistance) {
            observationProgress = targetDistance;
        }
    }
}
