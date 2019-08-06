package com.siniothk.comm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * API：http://localhost:11001/doc.html
 */

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.siniothk.comm.repository")
public class SinothkCommApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinothkCommApplication.class, args);
    }

}

