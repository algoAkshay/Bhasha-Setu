package com.bhashasetu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BhashaSetuApplication {
  public static void main(String[] args) { SpringApplication.run(BhashaSetuApplication.class, args); }
}
