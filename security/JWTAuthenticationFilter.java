package com.work.security;

import com.alibaba.fastjson2.JSON;
import com.google.common.collect.ImmutableMap;
import com.work.util.JwtUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Jiayu Liu
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
 
    public JWTAuthenticationFilter (AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        super.setFilterProcessesUrl("/api/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getParameter("username"),request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user= (User) authResult.getPrincipal();
        System.out.println(user.toString());

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        String role = authorities.iterator().next().toString();

        String token = JwtUtils.createToken(user.getUsername(), authorities.toString());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(ImmutableMap.of("token",JwtUtils.TOKEN_PREFIX + token,"role",role)));

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String returnData="";

        }

    }