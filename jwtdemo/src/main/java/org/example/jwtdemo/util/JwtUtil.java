package org.example.jwtdemo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    public static final String SECRET = "ad324as5465fs4fd65sdf65s23487349628grwihgfi872349283grfwieurt93847t53fuo89374tr872dwdfwd23r23dwedd4f654fsdfsfdsd"; // too short! (see note below)
    private final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
         String token = Jwts.builder()
                 .setSubject(username)
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis()+1000*3))
                 .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                 .compact();
        System.out.println("token: " + token);
        return token;
    }

    public boolean validateToken(@RequestParam String token) {

        try
        {
            Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token);
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Invalid token");
            return false;
        }
    }
}
