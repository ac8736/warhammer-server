package dev.warhammer.celestial_orrery.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtSecretKeyProvider {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static Key getSecretKey() {
        return SECRET_KEY;
    }

}
