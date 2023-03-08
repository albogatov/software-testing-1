package model;

import lombok.Data;

@Data
public abstract class Being {

    protected Feel feel;

    protected String name;

    protected Type type;

    public Being() {

    }

}
