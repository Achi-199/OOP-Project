/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Central controller of the space exploration unit.
 * <p>
 * The InterstellarCruiser orchestrates all main components of the Orion mission,
 * including navigation strategy, fuel management, propulsion, and piloting.
 * It supports loading mission targets, initiating launches, and executing 
 * destination logic under varying travel modes and fuel conditions.
 * </p>
 * 
 * @author Achi
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InterstellarCruiser {
    private final RouteManager navigator = new RouteManager();
    private final PropellantChamber chamber = new PropellantChamber(1000);
    private final ThrusterCore thruster = new ThrusterCore();
    private final AstroPilot pilot = new AstroPilot(this);
    private NavigationMode mode = NavigationMode.STANDARD;

    /**
     * Sets the navigation mode used for route decisions.
     *
     * @param mode the desired navigation strategy (STANDARD, EFFICIENT, EXPLORATION)
     */
    public void setNavigationMode(NavigationMode mode) {
        this.mode = mode;
        navigator.setMode(mode);
    }

    /**
     * Loads planetary destinations from a text file.
     * Each line must include: name, distance, fuelRate, scientificValue.
     *
     * @param filePath the path to the destinations file
     */
    public void importTargets(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String name = scanner.next();
                int distance = scanner.nextInt();
                int fuelRate = scanner.nextInt();
                int value = scanner.nextInt();
                navigator.registerStop(new PlanetStop(name, distance, fuelRate, value));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Destination file not found.");
        }
    }

    /**
     * Initiates the mission execution via the pilot.
     */
    public void beginMission() {
        pilot.executeCourse();
    }

    /**
     * Engages the shuttle's propulsion system.
     */
    public void engageThruster() {
        thruster.activate();
    }

    /**
     * Disengages the shuttle's propulsion system.
     */
    public void disengageThruster() {
        thruster.deactivate();
    }

    /**
     * Advances the shuttle's position and consumes fuel.
     * Movement affects the closest destination's travel progress.
     */
    public void advance() {
        PlanetStop stop = navigator.nextStop();
        if (stop == null) return;
        chamber.burnFuel(stop.getFuelRate());
        if (thruster.isEngaged()) {
            stop.updateProgress(50);
        }
    }

    /**
     * Checks if the fuel level is critically low.
     *
     * @return true if fuel is under 15% of capacity
     */
    public boolean fuelIsLow() {
        return chamber.isFuelCritical();
    }

    /**
     * Refills the fuel chamber to full capacity.
     */
    public void refillTank() {
        chamber.refill();
    }

    /**
     * Indicates whether there are remaining destinations to visit.
     *
     * @return true if pending destinations exist
     */
    public boolean hasMoreStops() {
        return navigator.hasPendingStops();
    }

    /**
     * Gets the next destination based on the current navigation mode.
     *
     * @return the selected PlanetStop
     */
    public PlanetStop getNearestStop() {
        return navigator.nextStop();
    }

    /**
     * Removes any destinations that have been fully reached.
     */
    public void clearCompletedStops() {
        navigator.discardCompletedStops();
    }
}
