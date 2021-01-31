package dev.kennethlindalen.rkupongoversikt.Security.JWT.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static dev.kennethlindalen.rkupongoversikt.Security.JWT.JWTContstants.TOKEN_VALIDITY;
import static dev.kennethlindalen.rkupongoversikt.Security.JWT.JWTContstants.JWT_SECRET;

@Component
public class JWTTokenManager implements Serializable {

    public static final long serialVersionUID = 7008375124389347049L;

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.ES512, JWT_SECRET).compact();
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }
}
