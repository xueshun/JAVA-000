package com.xuesran.datasource.masterslave.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The type Master slave application.
 *
 * @author xueshun
 */
@SpringBootApplication(scanBasePackages = {"com.xuesran.datasource.masterslave"})
@EntityScan(basePackages = {"com.xuesran.datasource.masterslave"})
public class MasterSlaveApplication extends SpringBootServletInitializer {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MasterSlaveApplication.class, args);
    }

}
