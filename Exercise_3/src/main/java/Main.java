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
    Moja aplikacja przedstawia podstawową telemetrię samochodu z pomocą 4 głównych komponentów:
        - Silnika
        - Skrzyni biegów
        - Hamulców
        - Układu kierowniczego
    Każdy komponent przechowuje conajmniej jeden controller oraz implementuje interfejs Runnable,
    dzięki czemu uruchamiane są w osobnych wątkach i działają niezależnie od siebie.
    Każdy controller implementuje interfejs Controller, składa się z conajmniej jednego sensora,
    który odpowiada za kontrole poszczególnych parametrów.
    Częstotliwość próbkowania jest losowa i odpowiada za nią klasa RandomTime.
    W swoim rozwiązaniu do wyświetlania logów użyłem biblioteki SLF4J oraz Project Lombok.
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
