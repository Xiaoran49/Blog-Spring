package com.example.synu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SynuSprApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SynuSprApplication.class, args);
        log.info("\n----------------------------------------------------------\n\t" +
                "Xiaoran Blog System  is running! System URLs:\n\t" +
                "Local访问网址: \t\t http://localhost:8080/ \n\t" +
                "Username:ran\t\t"+" "+"Password:947\n" +
                "----------------------------------------------------------");
    }

}
