package com.example.dtodemo.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
  @Value("${jwt.expiration}")
  private long expiration;
  private final Key secretKey;

  public JwtUtil(@Value("${jwt.secret}") String secretString) {
    this.secretKey = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.US_ASCII));
  }

  public String generateToken(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(secretKey)
        .compact();
  }
}
