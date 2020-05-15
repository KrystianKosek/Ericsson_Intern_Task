package sensor;

public class Tachometer {
    public String getRotation() {
        String rotations = String.valueOf((int) (Math.random() * 120));
        return rotations;
    }
}