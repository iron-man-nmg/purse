package com.zhuoqitech.timetravel.gaea.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author jianbingbing
 * @create 2019-06-03
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.nmg.purse.*"})
@MapperScan(basePackages = {"com.nmg.purse.dal"})
public class PurseServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PurseServletInitializer.class);
    }

}
