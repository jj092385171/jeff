package com.campingmapping.team4.spring.utils.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// @EnableMethodSecurity(prePostEnabled = true, securedEnabled = true,
// jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    private final JwtAuthenticationFilter jwtAuthFilter;
    @Autowired
    private final AuthenticationProvider authenticationProvider;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    // @Autowired
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuthUserService;
    @Autowired
    private final AuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  {
        try {
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
                    .oauth2Login(o -> o
                            .loginPage("/login")
                            .authorizationEndpoint(auth -> auth.baseUri("/login/oauth2/authorization"))
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
