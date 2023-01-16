package com.alibou.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // 關閉CSRF
        .csrf().disable()
        // 啟用jwt監聽
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        // 設定是否需要驗證的路徑
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(
                "/api/v1/auth/**",
                "/favicon.ico",
                "/index.html",
                "/oauth2/authorization/**",
                "/webjars/**",
                "/error",
                "/user",
                "/11.html",
                "/all.js")
            .permitAll()
            // .requestMatchers(HttpMethod.POST,"/users/")
            .anyRequest().authenticated())
        // 登入頁面
        .formLogin(formLogin -> formLogin
            .loginPage("/login.html")
            .defaultSuccessUrl("/")
            .permitAll())
        // 登出頁面
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll())
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

    ;

    return http.build();
  }
}
