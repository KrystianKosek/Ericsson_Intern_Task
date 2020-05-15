package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyModel {
    private String id;
    private String message;
    private String controlBit;

    public MyModel(String id, String message, String controlBit) {
        this.id = id;
        this.message = message;
        this.controlBit = controlBit;
    }

    @Override
    public String toString() {
        return id + message + controlBit;
    }
}
