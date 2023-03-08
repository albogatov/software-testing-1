package model;

public enum Feel {

    PHYSICAL("Физическое"),
    AUDIAL("Слуховое"),
    VISUAL("Зрительное");

    String text;

    Feel(String text) {
        this.text = text;
    }
}
