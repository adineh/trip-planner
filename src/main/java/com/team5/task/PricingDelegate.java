package com.team5.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component("pricing")
public class PricingDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(PricingDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        Random rnd = new Random();
        Integer price = rnd.nextInt(1000);

        execution.setVariable("price", new Long(price));

    }

}
