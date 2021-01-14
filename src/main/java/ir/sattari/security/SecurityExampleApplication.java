package ir.sattari.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class SecurityExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityExampleApplication.class, args);
    }

}
