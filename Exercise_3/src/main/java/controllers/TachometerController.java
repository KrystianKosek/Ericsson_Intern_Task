package controllers;

import lombok.extern.slf4j.Slf4j;
import sensor.Tachometer;

@Slf4j
public class TachometerController implements Controller {
    private Tachometer tachometer;
    private String componentName;

    public TachometerController(Tachometer tachometer, String componentName) {
        this.tachometer = tachometer;
        this.componentName = componentName;
    }

    @Override
    public void logSensorData() {
        String speed = tachometer.getRotation();
        log.info(String.format("%s: Current speed is: %s km/h", componentName, speed));
    }
}
