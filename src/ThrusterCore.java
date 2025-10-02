/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
/**
 * Represents the propulsion engine of the cruiser.
 */
public class ThrusterCore {
    private boolean engaged = false;

    /**
     * Activates the thruster engine.
     */
    public void activate() {
        engaged = true;
    }

    /**
     * Deactivates the thruster engine.
     */
    public void deactivate() {
        engaged = false;
    }

    /**
     * Checks if the thruster is currently active.
     *
     * @return true if active
     */
    public boolean isEngaged() {
        return engaged;
    }
}

