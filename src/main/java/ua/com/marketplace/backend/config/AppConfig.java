package ua.com.marketplace.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ua.com.marketplace.backend")
@PropertySource("classpath:application.dev.yml")
@RequiredArgsConstructor
public class AppConfig {


}
