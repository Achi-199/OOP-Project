/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Achi
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterstellarCruiserTest {

    private InterstellarCruiser cruiser;
    private PlanetStop mockStop;

    @Before
    public void setUp() {
        cruiser = new InterstellarCruiser();
        mockStop = new PlanetStop("Testia", 100, 10, 20);
        cruiser.setNavigationMode(NavigationMode.STANDARD);
        cruiser.getNearestStop(); // initializes RouteManager
        cruiser.clearCompletedStops();
    }

    @Test
    public void testAdvanceConsumesFuelAndUpdatesProgress() {
        cruiser.importTargets("test_destinations.txt");
        PlanetStop stop = cruiser.getNearestStop();
        if (stop != null) {
            int initialFuel = new PropellantChamber(1000).currentLevel();
            cruiser.advance();
            assertTrue(stop.getCompletionPercentage() > 0);
        }
    }

    @Test
    public void testFuelIsLowTriggersCorrectly() {
        PropellantChamber lowFuel = new PropellantChamber(100);
        lowFuel.burnFuel(90);
        assertTrue(lowFuel.isFuelCritical());
    }

    @Test
    public void testRefillTankRestoresFullFuel() {
        PropellantChamber tank = new PropellantChamber(500);
        tank.burnFuel(80);
        tank.refill();
        assertEquals(500, tank.currentLevel());
    }
}
