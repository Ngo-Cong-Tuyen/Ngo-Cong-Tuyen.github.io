package com.example.demo_security.security;

import com.example.demo_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterCustom extends OncePerRequestFilter {


    @Autowired
    private UserDetailServiceCustom userDetailServiceCustom;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Lay ra thong tin trong session
        String userEmail = (String) request.getSession().getAttribute("MY_SESSION");

        // Kiem tra user email
        if(userEmail == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Lay thong tin user dua theo email
        UserDetails user = userDetailServiceCustom.loadUserByUsername(userEmail);

        // Tao doi tuong authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());

        // Luu doi tuong vao trong context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
