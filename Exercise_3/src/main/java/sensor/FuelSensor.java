package sensor;

public class FuelSensor implements FluidSensor {
    @Override
    public String getPressure() {
        return "2.3";
    }

    @Override
    public String getLevel() {
        return "100";
    }
}
