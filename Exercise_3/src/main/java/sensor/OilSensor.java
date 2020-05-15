package sensor;


public class OilSensor implements FluidSensor, TemperatureSensor {
    @Override
    public String getPressure() {
        return "5.5";
    }

    @Override
    public String getLevel() {
        return "100";
    }

    @Override
    public int getTemperature() {
        return (int) (Math.random() * 50) + 50;
    }
}
