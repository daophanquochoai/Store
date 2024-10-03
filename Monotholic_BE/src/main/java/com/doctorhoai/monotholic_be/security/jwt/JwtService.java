package com.doctorhoai.monotholic_be.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    public String buildToken(
            Map<String,  Object> extractClaims,
            UserDetails userDetails,
            long expiration
    ){
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +  expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(   UserDetails  userDetails ){
        return buildToken(new HashMap<>(), userDetails, jwtExpiration);
    }
    public String generateRefreshToken(   UserDetails  userDetails ){
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }
    public Date extractExpiration( String token ){
        return extractClaim(token, Claims::getExpiration);
    }
    public Boolean isTokenExpired( String token ){
        return extractExpiration(token).before(new Date());
    }
    public Boolean isTokenValid( String token,  UserDetails  userDetails ){
        final String username   = extractUsername(token);
        return (username.equals(userDetails.getUsername())  &&  !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims  claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }
    public Claims extractAllClaims( String token ){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
