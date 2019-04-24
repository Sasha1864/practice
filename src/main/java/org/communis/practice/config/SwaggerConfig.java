//package org.communis.practice.config;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Collections;
//
//@EnableSwagger2
//@Configuration
//@ConditionalOnClass(Docket.class)
//@Log4j2
//public class SwaggerConfig {
//
//    public SwaggerConfig(){
//    }
//
//    @Bean
//    public Docket api() {
//        log.debug("Enable swagger");
//        return new Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//            .paths(PathSelectors.any())
//            .build()
//            .directModelSubstitute(LocalDate.class, java.sql.Date.class)
//            .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
//            .useDefaultResponseMessages(false)
//            .apiInfo(apiInfo())
//            .enableUrlTemplating(false);
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//            "TMP",
//            "REST API Application",
//            "0.0.1",
//            "",
//            null,
//            "", "", Collections.emptyList());
//    }
//}
