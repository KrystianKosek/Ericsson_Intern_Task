package controllers;

import lombok.extern.slf4j.Slf4j;
import sensor.OilSensor;

@Slf4j
public class OilController implements Controller {
    private OilSensor oilSensor;
    private String componentName;

    public OilController(OilSensor oilSensor, String componentName) {
        this.oilSensor = oilSensor;
        this.componentName = componentName;
    }

    @Override
    public void logSensorData() {
        String level = oilSensor.getLevel();
        String pressure = oilSensor.getPressure();
        int temperature = oilSensor.getTemperature();

        log.info(String.format("%s: Oil level is: level %s", componentName, level));
        log.info(String.format("%s: Oil pressure is: %s bar", componentName, pressure));
        log.info(String.format("%s: Oil temperature is: %d degrees", componentName, temperature));
        if (temperature > 85) {
            log.warn(String.format("%s: Oil temperature is too high!", componentName));
        }
    }
}