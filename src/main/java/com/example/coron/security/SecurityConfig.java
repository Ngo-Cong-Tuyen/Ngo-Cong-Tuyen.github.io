package com.example.coron.security;


import com.example.coron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationEntryPointCustom authenticationEntryPointCustom;

    @Autowired
    private FilterCustom filterCustom;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                    .antMatchers("/", "/api/auth/**","/api/v1/**").permitAll()
                    .antMatchers("/profile","/cart","/my-account", "/wishlist").hasRole("USER")
                    .antMatchers("/admin/**").hasAnyRole("EDITOR","ADMIN")
                    .antMatchers("/admin/users").hasRole("ADMIN")
                .and()
                    .formLogin()
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPointCustom)
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies("MY_SESSION")
                    .logoutSuccessUrl("/")
                    .permitAll()
                .and()
                    .addFilterBefore(filterCustom, UsernamePasswordAuthenticationFilter.class);
    }



}