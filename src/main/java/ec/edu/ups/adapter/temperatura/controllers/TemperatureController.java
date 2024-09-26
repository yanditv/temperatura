package ec.edu.ups.adapter.temperatura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ec.edu.ups.adapter.temperatura.models.CelsiusSensor;
import ec.edu.ups.adapter.temperatura.models.FahrenheitSensor;
import ec.edu.ups.adapter.temperatura.models.TemperatureAdapter;
import ec.edu.ups.adapter.temperatura.models.TemperatureSensor;
import ec.edu.ups.adapter.temperatura.services.TemperatureService;

@Controller
public class TemperatureController {

    @Autowired
    private TemperatureService service;

    // Mostrar todos los sensores
    @GetMapping("/")
    public String getAllSensors(Model model) {
        model.addAttribute("sensors", service.getAllSensors());
        return "index";
    }

    // Formulario para añadir un sensor
    @GetMapping("/addSensor")
    public String showAddSensorForm(Model model) {
        model.addAttribute("sensor", new CelsiusSensor(0.0));
        return "addSensor";
    }

    // Manejar el envío del formulario para añadir un sensor
    @PostMapping("/addSensor")
    public String addSensor(@ModelAttribute("sensor") CelsiusSensor sensor, @RequestParam String type) {
        if (type.equals("fahrenheit")) {
            FahrenheitSensor fahrenheitSensor = new FahrenheitSensor(sensor.getTemperature());
            TemperatureAdapter adapter = new TemperatureAdapter(fahrenheitSensor);
            service.addSensor(adapter);
        } else {
            service.addSensor(sensor);
        }
        return "redirect:/";
    }

    // Formulario para actualizar un sensor
    @GetMapping("/updateSensor/{index}")
    public String showUpdateSensorForm(@PathVariable("index") int index, Model model) {
        TemperatureSensor sensor = service.getSensor(index);
        model.addAttribute("sensor", sensor);
        model.addAttribute("index", index);
        return "updateSensor";
    }

    // Manejar el envío del formulario para actualizar un sensor
    @PostMapping("/updateSensor/{index}")
    public String updateSensor(@PathVariable("index") int index, @ModelAttribute("sensor") CelsiusSensor sensor) {
        service.updateSensor(index, sensor);
        return "redirect:/";
    }

    // Eliminar un sensor
    @GetMapping("/deleteSensor/{index}")
    public String deleteSensor(@PathVariable("index") int index) {
        service.removeSensor(index);
        return "redirect:/";
    }
}