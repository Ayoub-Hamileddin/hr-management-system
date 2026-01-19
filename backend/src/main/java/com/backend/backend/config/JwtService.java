package com.backend.backend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;




@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secret_key ;

    @Value("${jwt.access-token-expiration}")
    private Long access_token_expiration;

    @Value("${jwt.refresh-token-expiration}")
    private Long refresh_token_expiration;


    @PostConstruct
    public void checkSecret() {
        System.out.println("JWT SECRET = " + secret_key);
    }

    public Claims extractAllClaims(String jwt){
        return Jwts
        .parserBuilder()
        .setSigningKey(getSignKey())
        .build()
        .parseClaimsJws(jwt)
        .getBody();
    }

    
    public <T> T extractClaim(String jwt,Function<Claims,T> claimResolver){
        final Claims claims=extractAllClaims(jwt);
        return claimResolver.apply(claims);
    }


    public String extractUserName(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }


    public Boolean isTokenValid(String jwt,UserDetails userDetails){
        String userName=extractUserName(jwt);
        return userName.equals(userDetails.getUsername());
    }




    public String generateAccessToken(Map<String,Object> extraClaims,UserDetails userDetails){

        return genereteToken(extraClaims, userDetails, access_token_expiration);
            
    }

    public String generateRefreshToken(Map<String,Object> extraClaims,UserDetails userDetails){

        return genereteToken(extraClaims, userDetails, refresh_token_expiration);
            
    }


    private String genereteToken(Map<String,Object> extraClaims,UserDetails userDetails,Long expireTime){
        return Jwts
        .builder()
        .setClaims(extraClaims!=null? extraClaims:new HashMap<>())
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expireTime))
        .signWith(getSignKey(),SignatureAlgorithm.HS256)
        .compact();
    }
    

    private SecretKey getSignKey(){
        byte[]  keyBytes=secret_key.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }

}











