package com.first.helpdesk.service;

import io.jsonwebtoken.Jwts;
import com.first.helpdesk.entity.User;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey;
    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }
public String generateToken(String email){
    return Jwts.builder().subject(email).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+1000*60*60)).signWith(getSigningKey()).compact();
}
public String extractEmail(String token){
    return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
}
public boolean isTokenValid(String token,User user){
try{
    String email= extractEmail(token);
    return email.equals(user.getEmail());
}
catch (io.jsonwebtoken.JwtException | IllegalArgumentException e){
    return false;
}
}
    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            String email = extractEmail(token);
            return email.equals(userDetails.getUsername());
        } catch (io.jsonwebtoken.JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}