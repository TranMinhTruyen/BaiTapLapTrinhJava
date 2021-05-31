package com.example.common.jwt;

import com.example.common.user.CustomUserDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Component
@Slf4j
public class JWTTokenProvider {

    static final long EXPIRATIONTIME = 100000000;
    static final String SECRET = "UnlimitedBladeWork";

    public String generateToken(CustomUserDetail userDetail) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATIONTIME);
        Claims claims = Jwts.claims().setSubject(Integer.toString(userDetail.getUser().getId()));
        if (userDetail.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN")))
            claims.put("role", "ADMIN");
        else
            claims.put("role", "USER");
        String token = Jwts.builder()
                            .setClaims(claims)
                            .setIssuedAt(now)
                            .setExpiration(expiryDate)
                            .signWith(SignatureAlgorithm.HS512, SECRET)
                            .compact();
        return token;
    }

    public int getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Integer.parseInt(claims.getSubject());
    }

    public String getRoleFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return (String) claims.get("role");
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
