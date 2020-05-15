package components;

import controllers.OilController;
import lombok.extern.slf4j.Slf4j;
import utils.RandomTime;

@Slf4j
public class Gearbox implements Runnable {
    private OilController oilController;
    private RandomTime randomTime;

    public Gearbox(OilController oilController, RandomTime randomTime) {
        this.oilController = oilController;
        this.randomTime = randomTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(randomTime.getRandomTime());
                oilController.logSensorData();
            } catch (InterruptedException e) {
                log.error("Gearbox failure");
            }
        }
    }
}
