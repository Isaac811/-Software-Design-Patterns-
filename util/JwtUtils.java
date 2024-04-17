package com.work.util;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
import java.util.Date;
import java.util.HashMap;
 
public class JwtUtils {
    public static final String TOKEN_HEADER="Authorization";
    public static final String TOKEN_PREFIX="Bearer ";
    public static final long EXPIRATION=60*60*1000;
    public static final String SUBJECT="piconjo";
    public static final String HEADER_STRING="Passport";
    public static final String APPSECRET_KEY="piconjo_secret";
    public static final String ROLE_CLAIMS="role";
 

    public static String createToken(String username,String role){
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS,role);
        String token=Jwts.builder()
                        .setSubject(username)
                        .setClaims(map)
                        .claim("username",username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
                        .signWith(SignatureAlgorithm.HS512,APPSECRET_KEY)
                        .compact();
        return token;
    }


    public static Claims checkJWT(String token){
       try{
           Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
           return claims;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }
 

    public static String getUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }
 

    public static String getUserRole(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }
 

    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }
}