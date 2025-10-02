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
import java.util.List;
import static org.junit.Assert.*;

public class RouteManagerTest {

    private RouteManager manager;
    private PlanetStop stop1;
    private PlanetStop stop2;
    private PlanetStop stop3;

    @Before
    public void setUp() {
        manager = new RouteManager();
        stop1 = new PlanetStop("Venus", 300, 5, 20);
        stop2 = new PlanetStop("Mars", 800, 10, 50);
        stop3 = new PlanetStop("Neptune", 1500, 15, 100);
        manager.registerStop(stop1);
        manager.registerStop(stop2);
        manager.registerStop(stop3);
    }

    @Test
    public void testRegisterStopAddsDestinations() {
        List<PlanetStop> stops = manager.getStops();
        assertEquals(3, stops.size());
    }

    @Test
    public void testNextStopStandardModeReturnsNearest() {
        manager.setMode(NavigationMode.STANDARD);
        PlanetStop next = manager.nextStop();
        assertEquals("Venus", next.getLabel());
    }

    @Test
    public void testNextStopEfficientModeReturnsBestFuelEfficiency() {
        manager.setMode(NavigationMode.EFFICIENT);
        PlanetStop next = manager.nextStop();
        assertEquals("Neptune", next.getLabel());
    }

    @Test
    public void testNextStopExplorationModeReturnsHighestValue() {
        manager.setMode(NavigationMode.EXPLORATION);
        PlanetStop next = manager.nextStop();
        assertEquals("Neptune", next.getLabel());
    }

    @Test
    public void testDiscardCompletedStopsRemovesArrivedStops() {
        stop1.updateProgress(300);
        manager.discardCompletedStops();
        assertFalse(manager.getStops().contains(stop1));
    }
}