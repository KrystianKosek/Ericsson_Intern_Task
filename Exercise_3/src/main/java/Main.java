import components.Brakes;
import components.Engine;
import components.Gearbox;
import components.SteeringSystem;
import controllers.FuelController;
import controllers.OilController;
import controllers.SteeringController;
import controllers.TachometerController;
import sensor.FuelSensor;
import sensor.OilSensor;
import sensor.SteeringSystemSensor;
import sensor.Tachometer;
import utils.RandomTime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


    /*
    My application presents basic car telemetry with the help of 4 main components:
        - Engine
        - Gearboxes
        - Brakes
        - Steering gear
    Each component stores at least one controller and implements a Runnable interface,
    so that components run in separate threads and work independently of each other.
    Each controller implements a Controller interface, consisting of at least one sensor,
    who is responsible for checking the individual parameters.
    The sampling rate is random and the RandomTime class is responsible for it.
    In my solution I used SLF4J and Project Lombok libraries to display logs.
     */

public class Main {

    private static final String engineName = "Engine";
    private static final String brakesName = "Brakes";
    private static final String gearBoxName = "Gearbox";
    private static final String steeringSystemName = "Steering System";
    private static final long timeFactor = 5000;

    public static void main(String[] args) {
        RandomTime randomTime = new RandomTime(timeFactor);
        Engine engine = new Engine(new FuelController(new FuelSensor(), engineName),
                new OilController(new OilSensor(), engineName), randomTime);
        Brakes brakes = new Brakes(new OilController(new OilSensor(), brakesName), randomTime);
        Gearbox gearbox = new Gearbox(new OilController(new OilSensor(), gearBoxName), randomTime);
        SteeringSystem steeringSystem = new SteeringSystem(new SteeringController(new SteeringSystemSensor(), steeringSystemName),
                new TachometerController(new Tachometer(), steeringSystemName), randomTime);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(engine);
        executorService.submit(brakes);
        executorService.submit(gearbox);
        executorService.submit(steeringSystem);
    }
}
