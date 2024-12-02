package com.ys.skywingracing;

import org.springframework.boot.SpringApplication;

public class TestSkyWingRacingApplication {

    public static void main(String[] args) {
        SpringApplication.from(SkyWingRacingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
