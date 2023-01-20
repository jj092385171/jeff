package com.campingmapping.team4.spring.utils.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

        private final JwtAuthenticationFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                // 關閉CSRF
                                .csrf().disable()
                                // 設定是否需要驗證的路徑(更改成使用註釋)
                                .authorizeHttpRequests(authorize -> authorize
                                                // .requestMatchers(
                                                // "/api/v1/auth/**",
                                                // "/favicon.ico",
                                                // "/index.html",
                                                // "/oauth2/authorization/**",
                                                // "/webjars/**",
                                                // "/error",
                                                // "/user",
                                                // "/11.html",
                                                // "/all.js")
                                                // .permitAll()
                                                // .requestMatchers(HttpMethod.POST,"/users/")
                                                .anyRequest().permitAll())
                                // 啟用jwt監聽
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                                // 登入頁面
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login")
                                                .permitAll())
                                // 登出頁面
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/morari")
                                                .permitAll())
                                // 若無權限指定路徑
                                .exceptionHandling(exceptionHandling -> exceptionHandling
                                                .accessDeniedPage("/morari"))
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                return http.build();
        }
}
