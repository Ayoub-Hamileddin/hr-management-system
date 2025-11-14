package com.backend.backend.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;




@Service
public class JwtService {

    private final String SECRET_KEY="wUEIsKbbjn+3Wgu6TzDOk5MZ3BD4TbXlzdXBlclNlY3JldGZvcnRoaXNhcHBoaGho";




    public Claims extractAllClaims(String jwt){
        return Jwts
        .parser()
        .verifyWith(getSignKey())
        .build()
        .parseSignedClaims(jwt)
        .getPayload();
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


    public String generateToken(Map<String,Object> extraClaims,UserDetails userDetails){
        return Jwts
        .builder()
        .setClaims(extraClaims!=null? extraClaims:new HashMap<>())
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
        .signWith(getSignKey())
        .compact();
            
    }

    

    private SecretKey getSignKey(){
        byte[]  keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}











