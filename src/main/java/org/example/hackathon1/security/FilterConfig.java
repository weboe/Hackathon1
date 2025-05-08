package org.example.hackathon1.security;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthenticationFilter(new JwtTokenProvider()));
        registrationBean.addUrlPatterns("/api/*"); // Aplica el filtro a todos los endpoints bajo "/api/"
        return registrationBean;
    }
}

