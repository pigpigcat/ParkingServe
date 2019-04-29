package com.github.core.config;

import com.github.core.component.RestAuthenticationEntryPoint;
import com.github.core.component.RestfulAccessDeniedHandler;
import com.github.core.util.JwtTokenUtils;
import com.github.core.component.CustomFormLoginConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 自定义Spring Security配置类
 *
 * @author wulitech
 * @version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsService userDetailsService;

    private final JwtTokenUtils jwtTokenUtils;

    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public SecurityConfig(@Qualifier("customUserDetailServiceImpl") UserDetailsService userDetailsService, RestfulAccessDeniedHandler restfulAccessDeniedHandler, RestAuthenticationEntryPoint restAuthenticationEntryPoint, JwtTokenUtils jwtTokenUtils) {
        this.userDetailsService = userDetailsService;
        this.restfulAccessDeniedHandler = restfulAccessDeniedHandler;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("进入自定义Spring Security配置");
        // 使用的是JWT，这里不需要csrf
        http.cors()
                .and()
                .csrf().disable()
                // 基于token，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .apply(new CustomFormLoginConfigurer<>(authenticationManager(), jwtTokenUtils)).loginProcessingUrl("/parking/login")
//                .authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll()
                .and()
                // "/parking/**"需要验证
//                .authorizeRequests().antMatchers("/parking/**").authenticated()
                // 其他路径允许匿名访问
//                .anyRequest().permitAll()
//                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenUtils))
                //添加自定义未授权和未登录结果返回
                .exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(createBCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder createBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return new CorsFilter(source);
    }

}
