package dev.patika.patikahw04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PatikaHw04Application {

    public static void main(String[] args) {
        SpringApplication.run(PatikaHw04Application.class, args);
    }

}
