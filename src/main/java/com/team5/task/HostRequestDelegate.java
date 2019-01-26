package com.team5.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("hostrequester")
public class HostRequestDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(HostRequestDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Pretending message somehow was sent");
    }

}
