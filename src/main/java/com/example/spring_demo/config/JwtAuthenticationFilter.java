package com.example.spring_demo.config;

import com.example.spring_demo.services.JwtServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends OncePerRequestFilter {

  private final JwtServices jwtServices;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
    @NonNull HttpServletRequest request,
    @NonNull HttpServletResponse response,
    @NonNull FilterChain filterChain

  ) throws ServletException, IOException {
    final String authHeader=request.getHeader("Authorization");
    final String jwt;
    final String email;

    if(authHeader == null || !authHeader.startsWith("Bearer")) {
      filterChain.doFilter(request,response);
      return;
    }
    jwt=authHeader.substring(7);
    email=jwtServices.extractUsername(jwt);
    if(email !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
      UserDetails userDetails=this.userDetailsService.loadUserByUsername(email);
      if(jwtServices.isTokenValid(jwt,userDetails)) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken
          (userDetails,null,userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }

    }
    filterChain.doFilter(request,response);

  }
}
