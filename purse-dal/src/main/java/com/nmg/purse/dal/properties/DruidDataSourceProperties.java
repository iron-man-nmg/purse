package com.nmg.purse.dal.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jianbingbing
 * @create 2019-06-06
 **/
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
}
