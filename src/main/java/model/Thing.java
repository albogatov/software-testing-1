package model;


import lombok.Data;

@Data
public class Thing {

    private String name;

    public Thing(String name) {
        this.name = name;
    }

}
