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

public class PlanetStopTest {

    private PlanetStop stop;

    @Before
    public void setUp() {
        stop = new PlanetStop("Jupiter", 1000, 10, 80);
    }

    @Test
    public void testRemainingDistanceInitiallyEqualsTotalDistance() {
        assertEquals(1000, stop.remainingDistance());
    }

    @Test
    public void testHasArrivedInitiallyFalse() {
        assertFalse(stop.hasArrived());
    }

    @Test
    public void testUpdateProgressIncreasesTravelledUnits() {
        stop.updateProgress(200);
        assertEquals(800, stop.remainingDistance());
    }

    @Test
    public void testHasArrivedTrueWhenReached() {
        stop.updateProgress(1000);
        assertTrue(stop.hasArrived());
    }

    @Test
    public void testUpdateProgressCapsAtTargetDistance() {
        stop.updateProgress(1200);
        assertEquals(0, stop.remainingDistance());
        assertTrue(stop.hasArrived());
    }
}
