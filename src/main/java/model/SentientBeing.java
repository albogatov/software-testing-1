package model;

import lombok.Data;

@Data
public class SentientBeing extends Being {

    private State state;

    public SentientBeing(String name, Type type) {
        this.name = name;
        this.type = type;
        this.state = State.STABLE;
        this.feel = null;
    }

    public void hit(SentientBeing being) {
        System.out.println(this.name + " ударяет " + being.name);
        being.experienceShock();
        being.setFeel(Feel.PHYSICAL);
    }

    public void stare(Thing thing) {
        System.out.println(this.name + " глядит на " + thing.getName());
        setFeel(Feel.VISUAL);
    }

    public void experienceShock() {
        System.out.println(this.name + " испытывает шок");
        setState(State.FLABBERGASTED);
    }

    public boolean isInBadTrip() {
        return this.state == State.DISGUST && this.feel == Feel.VISUAL;
    }

}
