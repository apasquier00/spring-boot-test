package com.example.spring_boot_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
    @Autowired
    private HeartbeatSensor heartbeatSensor;


}
