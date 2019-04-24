//package org.communis.practice.config;
//
//import org.apache.commons.io.IOUtils;
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.config.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
///**
// * @author simon
// */
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    final AppProperties appProperties;
//
//    public WebMvcConfig(AppProperties appProperties) {
//        this.appProperties = appProperties;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
//
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//    }
//
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.viewResolver((viewName, locale) -> new View() {
//            @Override
//            public String getContentType() {
//                return "text/html";
//            }
//
//            @Override
//            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//                ClassPathResource classPathResource = new ClassPathResource("/templates/" + viewName);
//                IOUtils.copy(classPathResource.getInputStream(), response.getOutputStream());
//                response.setContentType("text/html");
//            }
//        });
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/**")
//                    .allowedOrigins("*")
//                    .allowedMethods("*")
//                    .allowedHeaders("*");
//    }
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false);
//    }
//
//    @Bean
//    public ErrorProperties errorProperties() {
//        return new ErrorProperties();
//    }
//}
