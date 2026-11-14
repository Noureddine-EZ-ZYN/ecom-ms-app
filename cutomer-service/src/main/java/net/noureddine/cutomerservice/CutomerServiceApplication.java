package net.noureddine.cutomerservice;

import net.noureddine.cutomerservice.Config.CustomerConfigParams;
import net.noureddine.cutomerservice.entities.Customer;
import net.noureddine.cutomerservice.reposetory.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CutomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CutomerServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
customerRepository.save(Customer.builder().name("Mohammed").email("mohammed@gmail.com").build());
            customerRepository.save(Customer.builder().name("amine").email("amine@gmail.com").build());
        };
    }
}
