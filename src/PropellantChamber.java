/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
/**
 * Controls and monitors the propellant level of the cruiser.
 */
public class PropellantChamber {
    private final int capacity;
    private int fuelLevel;

    /**
     * Initializes the chamber with the given capacity.
     *
     * @param capacity the full tank fuel capacity
     */
    public PropellantChamber(int capacity) {
        this.capacity = capacity;
        this.fuelLevel = capacity;
    }

    /**
     * Consumes a percentage of the tank based on the input rate.
     *
     * @param percent the rate of fuel usage
     */
    public void burnFuel(int percent) {
        fuelLevel -= capacity * percent / 100;
        if (fuelLevel < 0) fuelLevel = 0;
    }

    /**
     * Checks whether the current fuel is below 15%.
     *
     * @return true if fuel is critically low
     */
    public boolean isFuelCritical() {
        return fuelLevel < capacity * 0.15;
    }

    /**
     * Refills the fuel tank to full.
     */
    public void refill() {
        fuelLevel = capacity;
    }

    public int currentLevel() {
        return fuelLevel;
    }
}
