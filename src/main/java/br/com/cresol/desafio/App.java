package br.com.cresol.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author fernando
 *
 */

@SpringBootApplication(scanBasePackages = { "br.com.cresol.desafio" })
@EntityScan({ "*br.com.cresol.desafio.model." })
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    
}