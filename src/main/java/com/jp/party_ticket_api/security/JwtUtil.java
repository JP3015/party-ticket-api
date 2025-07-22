package com.jp.party_ticket_api.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	 @Value("${jwt.secret}")
	 private String secret;
	
    public String gerarToken(UserDetails userDetails) {
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .claim("role", userDetails.getAuthorities())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public String extrairUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            .getBody().getSubject();
    }
    
    public String extrairRole(String token) {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .get("role", String.class);
    }
    
    public boolean validarToken(String token, UserDetails userDetails) {
        final String username = extrairUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpirado(token);
    }

    private boolean isTokenExpirado(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            .getBody().getExpiration().before(new Date());
    }
}

