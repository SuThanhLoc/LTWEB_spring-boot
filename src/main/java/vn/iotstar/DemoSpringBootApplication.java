package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Spring Boot sẽ tự scan các package con (Controller, Service, Repository, Entity)
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }

}
