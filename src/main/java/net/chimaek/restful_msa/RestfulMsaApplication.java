package net.chimaek.restful_msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestfulMsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulMsaApplication.class, args);
    }

}
