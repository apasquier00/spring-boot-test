package com.example.spring_boot_test;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class RandomHeartbeat implements HeartbeatSensor{

    @Override
    public int get() {
        return 0;
    }
}
