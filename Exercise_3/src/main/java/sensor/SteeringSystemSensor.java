package sensor;


public class SteeringSystemSensor {
    public String getTurningRadius() {
        String radius = String.valueOf((int) (Math.random() * 50) - 25);
        return radius;
    }
}
