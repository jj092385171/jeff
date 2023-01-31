package com.campingmapping.team4.spring.utils.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.campingmapping.team4.spring.utils.service.OAuth2UserServiceImpl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    private final JwtAuthenticationFilter jwtAuthFilter;
    @Autowired
    private final AuthenticationProvider authenticationProvider;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private final OAuth2UserServiceImpl oAuth2UserServiceImpl;
    @Autowired
    private final AuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 關閉CSRF
                .csrf().disable()
                // 設定是否需要驗證的路徑(更改成使用註釋)
                .authorizeHttpRequests()
                .requestMatchers("/admin").hasAnyAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
                // 啟用jwt監聽
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                // 登入頁面
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll())
                // OAuth2登入
                .oauth2Login(oAuth2 -> oAuth2
                        .loginPage("/login")
                        .authorizationEndpoint(authorization -> authorization
                                .baseUri("/login/oauth2/authorization"))
                        .userInfoEndpoint(e -> e.userService(oAuth2UserServiceImpl))
                        .successHandler(successHandler))
                // 登出頁面
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .permitAll())
                // 若無權限指定路徑
                // .exceptionHandling(exceptionHandling -> System.out.println("88")
                // exceptionHandling.accessDeniedPage("/home") )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
