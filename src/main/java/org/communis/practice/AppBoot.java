package org.communis.practice;

import org.communis.practice.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableConfigurationProperties
public class AppBoot {
    private final AppProperties appProperties;

    public AppBoot(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone(appProperties.getTimezone()));
    }

    public static void main(String[] args) {
        SpringApplication.run(AppBoot.class, args);
    }
}
