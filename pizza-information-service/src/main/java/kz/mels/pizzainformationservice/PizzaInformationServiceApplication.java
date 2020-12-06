package kz.mels.pizzainformationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PizzaInformationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaInformationServiceApplication.class, args);
    }

}
