package controllers;

import lombok.extern.slf4j.Slf4j;
import sensor.SteeringSystemSensor;

@Slf4j
public class SteeringController implements Controller {
    private SteeringSystemSensor steeringSystemSensor;
    private String componentName;

    public SteeringController(SteeringSystemSensor steeringSystemSensor, String componentName) {
        this.steeringSystemSensor = steeringSystemSensor;
        this.componentName = componentName;
    }

    @Override
    public void logSensorData() {
        String steeringRadius = steeringSystemSensor.getTurningRadius();
        log.info(String.format("%s: Current steering radius is: %s degrees", componentName, steeringRadius));
    }
}
