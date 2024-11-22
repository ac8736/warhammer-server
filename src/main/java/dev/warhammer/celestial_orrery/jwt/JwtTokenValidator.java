package dev.warhammer.celestial_orrery.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;

public class JwtTokenValidator {

    private static final Key SECRET_KEY = JwtSecretKeyProvider.getSecretKey();

    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
