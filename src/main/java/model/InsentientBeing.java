package model;

public class InsentientBeing extends Being {

    public InsentientBeing(String name, Type type) {
        this.name = name;
        this.type = type;
        this.feel = null;
    }

    public void slipIntoBeing(SentientBeing being) {
        System.out.println(this.name + " проскальзывает в " + being.getName());
        being.setState(State.DISGUST);
    }

}
