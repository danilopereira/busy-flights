package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.config.BusyFlightsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@Import(BusyFlightsConfig.class)
@ComponentScan({"com.travix.medusa.busyflights.web"})
@EnableAsync
public class BusyFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
}
