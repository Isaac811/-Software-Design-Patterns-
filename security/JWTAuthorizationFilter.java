package com.work.security;

import com.work.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
 
    private AuthenticationManager authenticationManager;
 
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenHeader=request.getHeader(JwtUtils.TOKEN_HEADER);
        if (tokenHeader==null || !tokenHeader.startsWith(JwtUtils.TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        super.doFilterInternal(request,response,chain);
    }
 
    public UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader){

        String token = tokenHeader.replace(JwtUtils.TOKEN_PREFIX, "");
        String username=JwtUtils.getUsername(token);
        String role=JwtUtils.getUserRole(token);
        String[] roles = StringUtils.strip(role, "[]").split(",");
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (String s : roles) {
            authorities.add(new SimpleGrantedAuthority(s));
        }
        if (username!=null){
            return new UsernamePasswordAuthenticationToken(username,null,authorities);
        }
        return null;
    }
}