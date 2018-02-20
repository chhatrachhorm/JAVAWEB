package model.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTHelper {
    private static String key = "fjsljflsjfklfsfs5f465s415s15f41sfsvsfs4fs1fs1f5654s";
    public static String generateToken(String subject, String issuer, String id){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long now = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(new Date(now))
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, key)
                .setExpiration(new Date(now + (15 * 60 * 1000)));
        return builder.compact();
    }
    public static Map<String, Object> validateToken(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Map<String, Object> results = new HashMap<>();
        results.put("error", "Invalid Token");
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwt)
                    .getBody();
            System.out.println("ID: " + claims.getId());
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Issuer: " + claims.getIssuer());
            System.out.println("Expiration: " + claims.getExpiration());
            results.clear();
            results.put("Subject", claims.getSubject());
            return results;
        } catch (Exception e){
            return results;
        }
    }

}
