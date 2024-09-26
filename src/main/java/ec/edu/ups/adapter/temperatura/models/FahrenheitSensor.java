package ec.edu.ups.adapter.temperatura.models;

public class FahrenheitSensor {
    private double temperature;

    public FahrenheitSensor(double temperature) {
        this.temperature = temperature;
    }

    public double getFahrenheitTemperature() {
        return temperature;
    }

    public void setFahrenheitTemperature(double temperature) {
        this.temperature = temperature;
    }
}