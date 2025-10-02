/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
/**
 * Executes the flight course, navigating between all planned stops.
 */
public class AstroPilot {
    private PlanetStop current;
    private PlanetStop upcoming;
    private final InterstellarCruiser cruiser;

    /**
     * Constructs the AstroPilot with a reference to the cruiser.
     *
     * @param cruiser the spacecraft to be controlled
     */
    public AstroPilot(InterstellarCruiser cruiser) {
        this.cruiser = cruiser;
        this.current = null;
    }

    /**
     * Runs the mission until all destinations are visited.
     */
    public void executeCourse() {
        while (cruiser.hasMoreStops()) {
            upcoming = cruiser.getNearestStop();
            if (upcoming == null) return;

            System.out.println("Approaching: " + upcoming.getLabel());
            cruiser.engageThruster();

            while (!upcoming.hasArrived()) {
                if (cruiser.fuelIsLow()) {
                    if (Math.random() < 0.5) {
                        System.out.println("Refueling...");
                        cruiser.refillTank();
                    } else {
                        System.out.println("Thruster disengaged due to critical fuel.");
                        cruiser.disengageThruster();
                        break;
                    }
                }

                cruiser.advance();
                System.out.println("Progress to " + upcoming.getLabel() + ": " +
                        String.format("%.1f", upcoming.getCompletionPercentage()) + "%");
            }

            if (upcoming.hasArrived()) {
                System.out.println(upcoming.getLabel() + " reached!");
                current = upcoming;
                cruiser.clearCompletedStops();
            }

            cruiser.disengageThruster();
        }
        System.out.println("Expedition accomplished. All destinations explored.");
    }
}
