package com.example.Content.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter  extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String authHeader=request.getHeader("authorization");

        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
        } else if (authHeader==null || !authHeader.startsWith("Bearer")) {
            throw new ServletException("Missing or invalid exception");
        }
        String token=authHeader.substring(7);
        Claims claims= Jwts.parser().setSigningKey("mysecurekey").parseClaimsJws(token).getBody();
        System.out.println("claims in filter:"+claims);
        request.setAttribute("claims",claims);
        filterChain.doFilter(request,response);
    }
}
