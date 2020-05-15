package components;

import controllers.FuelController;
import controllers.OilController;
import lombok.extern.slf4j.Slf4j;
import utils.RandomTime;

@Slf4j
public class Engine implements Runnable {
    private FuelController fuelController;
    private OilController oilController;
    private RandomTime randomTime;

    public Engine(FuelController fuelController, OilController oilController, RandomTime randomTime) {
        this.fuelController = fuelController;
        this.oilController = oilController;
        this.randomTime = randomTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(randomTime.getRandomTime());
                fuelController.logSensorData();
                oilController.logSensorData();
            } catch (InterruptedException e) {
                log.error("Engine failure");
            }
        }
    }
}
