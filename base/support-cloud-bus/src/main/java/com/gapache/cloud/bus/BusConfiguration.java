package com.gapache.cloud.bus;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = BusConfiguration.class)
public class BusConfiguration {

}
