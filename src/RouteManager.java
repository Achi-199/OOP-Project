/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
import java.util.*;

/**
 * Handles a collection of travel destinations and provides navigation support.
 */
public class RouteManager {

    private final List<PlanetStop> waypoints = new ArrayList<>();
    private NavigationMode mode = NavigationMode.STANDARD;

    public void setMode(NavigationMode mode) {
        this.mode = mode;
    }

    /**
     * Registers a new travel destination.
     *
     * @param stop the destination to be added
     */
    public void registerStop(PlanetStop stop) {
        waypoints.add(stop);
    }

    public void discardCompletedStops() {
        waypoints.removeIf(PlanetStop::hasArrived);
    }

    /**
     * Returns the next destination based on the navigation strategy.
     */
    public PlanetStop nextStop() {
        return switch (mode) {
            case STANDARD ->
                waypoints.stream()
                .min(Comparator.comparingInt(PlanetStop::remainingDistance)).orElse(null);
            case EFFICIENT ->
                waypoints.stream()
                .min(Comparator.comparingDouble(stop -> stop.getFuelRate() / (double) stop.remainingDistance())).orElse(null);
            case EXPLORATION ->
                waypoints.stream()
                .max(Comparator.comparingInt(PlanetStop::getScientificValue)).orElse(null);
        };
    }

    public boolean hasPendingStops() {
        return !waypoints.isEmpty();
    }

    /**
     * Returns all registered planet stops.
     *
     * @return list of waypoints
     */
    public List<PlanetStop> getStops() {
        return waypoints;
    }

}
