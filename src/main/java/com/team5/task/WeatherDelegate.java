package com.team5.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component("weather")
public class WeatherDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(WeatherDelegate.class.getName());

    private static final String[] CITIES = {"London", "New York", "Berlin", "Lisbon", "Paris", "Moscow", "Tokyo", "Melbourne"};

    public void execute(DelegateExecution execution) throws Exception {

        Random rnd = new Random();
        Integer index = rnd.nextInt(CITIES.length);

        execution.setVariable("city", CITIES[index]);
    }

}
