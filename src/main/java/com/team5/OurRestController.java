package com.team5;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class OurRestController {

    @Autowired private RuntimeService runtimeService;

    @GetMapping("/process/{bk}/start")
    public String processStart(@PathVariable("bk") String bk) {
       ProcessInstance pi = runtimeService.startProcessInstanceByKey("trip_planning", bk);
       return pi.getId();
    }

    @GetMapping("/process/{bk}/reply")
    public void reply(@PathVariable("bk") String bk) {
        runtimeService.correlateMessage("host_request", bk);
    }

}
