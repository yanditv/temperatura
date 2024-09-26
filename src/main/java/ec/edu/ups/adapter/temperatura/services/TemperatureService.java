package ec.edu.ups.adapter.temperatura.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.ups.adapter.temperatura.models.TemperatureSensor;

@Service
public class TemperatureService {
    private List<TemperatureSensor> sensors;

    public TemperatureService() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(TemperatureSensor sensor) {
        sensors.add(sensor);
    }

    public List<TemperatureSensor> getAllSensors() {
        return sensors;
    }

    public TemperatureSensor getSensor(int index) {
        if (index >= 0 && index < sensors.size()) {
            return sensors.get(index);
        }
        return null;
    }

    public void updateSensor(int index, TemperatureSensor sensor) {
        if (index >= 0 && index < sensors.size()) {
            sensors.set(index, sensor);
        }
    }

    public void removeSensor(int index) {
        if (index >= 0 && index < sensors.size()) {
            sensors.remove(index);
        }
    }
}