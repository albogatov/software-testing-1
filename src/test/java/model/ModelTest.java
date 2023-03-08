package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModelTest {

    static InsentientBeing fish;

    static SentientBeing ford;

    static SentientBeing arthur;

    static Thing earCanal;

    static Thing silhouette;

    @BeforeAll
    public static void init() {
        fish = new InsentientBeing("Рыбка", Type.ANIMAL);
        ford = new SentientBeing("Форд", Type.HUMAN);
        arthur = new SentientBeing("Артур", Type.HUMAN);
        earCanal = new Thing("Слуховой канал");
        silhouette = new Thing("Силуэт");

        assertNull(fish.getFeel());
        assertNull(ford.getFeel());
        assertNull(arthur.getFeel());
    }

    @Test
    public void checkHitImpact() {
        assertEquals(arthur.getState(), State.STABLE);
        ford.hit(arthur);
        assertEquals(arthur.getFeel(), Feel.PHYSICAL);
        assertEquals(arthur.getState(), State.FLABBERGASTED);
    }

    @Test
    public void checkStaring() {
        arthur.stare(silhouette);
        assertEquals(arthur.getFeel(), Feel.VISUAL);
    }

    @Test
    public void checkSlip() {
        fish.slipIntoBeing(arthur);
        assertEquals(arthur.getState(), State.DISGUST);
    }

    @Test
    public void checkStates() {
        arthur.setState(State.STABLE);
        assertEquals(arthur.getState(), State.STABLE);
        arthur.setState(State.FLABBERGASTED);
        assertEquals(arthur.getState(), State.FLABBERGASTED);
        arthur.setState(State.FROZEN);
        assertEquals(arthur.getState(), State.FROZEN);
        arthur.setState(State.FEAR);
        assertEquals(arthur.getState(), State.FEAR);
        arthur.setState(State.DISGUST);
        assertEquals(arthur.getState(), State.DISGUST);
    }

    @Test
    public void checkFeel() {
        fish.setFeel(Feel.AUDIAL);
        assertEquals(fish.getFeel(), Feel.AUDIAL);
        fish.setFeel(Feel.VISUAL);
        assertEquals(fish.getFeel(), Feel.VISUAL);
        fish.setFeel(Feel.PHYSICAL);
        assertEquals(fish.getFeel(), Feel.PHYSICAL);
    }

    @Test
    public void checkBadTrip() {
        fish.slipIntoBeing(ford);
        ford.stare(silhouette);
        assertEquals(ford.isInBadTrip(), true);
    }

}
