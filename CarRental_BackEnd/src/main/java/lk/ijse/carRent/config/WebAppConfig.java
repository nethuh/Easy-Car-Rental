package lk.ijse.carRent.config;

import lk.ijse.carRent.advisor.AppWideExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class}, basePackages = "lk.ijse.carRent.controller")
public class WebAppConfig implements WebMvcConfigurer {
}
