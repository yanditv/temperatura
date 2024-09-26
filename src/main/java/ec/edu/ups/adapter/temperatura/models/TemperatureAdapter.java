package ec.edu.ups.adapter.temperatura.models;

public class TemperatureAdapter implements TemperatureSensor {
    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperature() {
        // Convierte de Fahrenheit a Celsius
        return (fahrenheitSensor.getFahrenheitTemperature() - 32) * 5 / 9;
    }

    public void setTemperature(double temperature) {
        // Convierte de Celsius a Fahrenheit y lo establece en el sensor
        double fahrenheit = (temperature * 9 / 5) + 32;
        fahrenheitSensor.setFahrenheitTemperature(fahrenheit);
    }
}