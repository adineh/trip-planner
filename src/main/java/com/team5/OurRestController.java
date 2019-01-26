package com.team5;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trip")
public class OurRestController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/process/{bk}/start")
    public String processStart(@PathVariable("bk") String bk) {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("trip_planning", bk);
        return pi.getId();
    }

    @GetMapping("/process/{bk}/reply")
    public void reply(@PathVariable("bk") String bk,
                      @QueryParam("foo") String host) {
        Map<String, Object> hostingMap = new HashMap<>();
        hostingMap.put("host", host);
        runtimeService.correlateMessage("host_request", bk, hostingMap);
    }

}
