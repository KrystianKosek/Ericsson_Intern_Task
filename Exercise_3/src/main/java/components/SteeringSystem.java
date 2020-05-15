package components;

import controllers.SteeringController;
import controllers.TachometerController;
import lombok.extern.slf4j.Slf4j;
import utils.RandomTime;

@Slf4j
public class SteeringSystem implements Runnable {
    private SteeringController steeringController;
    private TachometerController tachometerController;
    private RandomTime randomTime;

    public SteeringSystem(SteeringController steeringController, TachometerController tachometerController, RandomTime randomTime) {
        this.steeringController = steeringController;
        this.tachometerController = tachometerController;
        this.randomTime = randomTime;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(randomTime.getRandomTime());
                steeringController.logSensorData();
                tachometerController.logSensorData();
            } catch (InterruptedException e) {
                log.error("Steering System failure");
            }
        }
    }
}
