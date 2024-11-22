package dev.warhammer.celestial_orrery.jwt;

import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenProvider {

    private static final long EXPIRATION_TIME = 86400000;
    private static final Key SECRET_KEY = JwtSecretKeyProvider.getSecretKey();

    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "USER");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

}
