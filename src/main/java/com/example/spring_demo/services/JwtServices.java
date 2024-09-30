package com.example.spring_demo.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServices {

  private static final String SECRET = "LBEg4ejf9t55YOWokLl0Sux3DEFJoxpSoLFOZKOg4seHnzZ7KxSwYPK3PJbWh2Sl/fO5toYhLcJlbe1FudW0g9mUdjsxaQmPoxeTafwQs7w09Y0KHHk1j9iQGy2dN6zt+DqHfq+6n0abIn9naSY9tc3AQBTC0uHAlCpBbZyJNlOqXJq2GBc4+UBxqeXqZNE6iGH0FKVaK/9NgTEx2ms+o7ULVHHjczXep70uEmIl/K+ZwlNFmeHH5GjQ/zbBCqRrgVxwHOFkTNwuMpO0tniWxGbpb9APUkr4rS1CI+4Cco0CwMh0mdqlHyG5TtysMMM+rW3WOAGU8j1nIxk1VyaD9uoHXRHep4RcUq9LSllYQOk";


  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }


  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }


  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }


  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts
      .builder()
      .setClaims(extraClaims)
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
      .signWith(getSignInKey(), SignatureAlgorithm.HS256)
      .compact();
  }


  public boolean isTokenValid(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }


  private boolean isTokenExpired(String token) {
    return extractExpirationDate(token).before(new Date());
  }


  private Date extractExpirationDate(String token) {
    return extractClaim(token, Claims::getExpiration);
  }


  private Claims extractAllClaims(String token) {
    return Jwts
      .parserBuilder()
      .setSigningKey(getSignInKey())
      .build()
      .parseClaimsJws(token)
      .getBody();
  }


  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
