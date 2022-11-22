package com.example.demo_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Role: user, editor, admin
    // user vao profile
    // editor: vao profile, quan ly bai viet
    // admin: vao profile, quan ly bai viet , quan ly user
    @Autowired
    private UserDetailServiceCustom userDetailServiceCustom;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceCustom).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/admin/blogs").hasAnyRole("ADMIN","EDITOR")
                .antMatchers("/admin/users").hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/") //KHi login thanh cong redirect ve "/"
                    .loginProcessingUrl("/login") // Thay doi duong dan login
                    .usernameParameter("email") // Thay doi truong user
                    .passwordParameter("password") // thay doi truong password
                    .permitAll()
                .and()
                    .logout()
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/")
                    .permitAll()
                .and()
                    .httpBasic();
    }


}
