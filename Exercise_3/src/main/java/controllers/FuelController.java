package controllers;

import lombok.extern.slf4j.Slf4j;
import sensor.FuelSensor;

@Slf4j
public class FuelController implements Controller {
    private FuelSensor fuelSensor;
    private String componentName;

    public FuelController(FuelSensor fuelSensor, String componentName) {
        this.fuelSensor = fuelSensor;
        this.componentName = componentName;
    }

    @Override
    public void logSensorData() {
        String level = fuelSensor.getLevel();
        String pressure = fuelSensor.getPressure();
        log.info(String.format("%s: Fuel level is: level %s", componentName, level));
        log.info(String.format("%s: Fuel pressure is: %s bar", componentName, pressure));
    }
}
