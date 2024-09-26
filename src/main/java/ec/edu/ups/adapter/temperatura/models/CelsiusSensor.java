package ec.edu.ups.adapter.temperatura.models;

public class CelsiusSensor implements TemperatureSensor {
    private double temperature;

    public CelsiusSensor(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}