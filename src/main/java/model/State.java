package model;

public enum State {

    STABLE("Обычное"),
    FLABBERGASTED("Шокирован"),
    FROZEN("Застыл"),
    FEAR("Страх"),
    DISGUST("Отвращение");

    String text;

    State(String text) {
        this.text = text;
    }
}
