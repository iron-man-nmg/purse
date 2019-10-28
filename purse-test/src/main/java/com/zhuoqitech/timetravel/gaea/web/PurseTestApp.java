package com.zhuoqitech.timetravel.gaea.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: renzhengbin
 * @Date: 19/6/12 17:11
 * @Version 1.0
 */
@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.nmg.purse"})
public class PurseTestApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PurseTestApp.class);
        app.run(args);
    }
}
