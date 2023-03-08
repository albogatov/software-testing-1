package model;

public enum Type {
    HUMAN("Человек"),
    ANIMAL("Животное"),
    ALIEN("Инопланетянин"),
    UNKNOWN_SPECIES("Чудо-юдо");

    String text;

    Type(String text) {
        this.text = text;
    }
}
