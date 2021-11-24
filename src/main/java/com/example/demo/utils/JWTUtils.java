package com.example.demo.utils;

import com.example.demo.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * author MaoYu
 * 2021/7/7
 */
public class JWTUtils {

    /**
     * 过期时间
     */
    private static final long EXPIRE = 6000 * 60 * 24 * 7;

    //密钥
    private static final String SECRET = "myxym.love";

    private static final String TOKEN_PREFIX = "mxyxm";

    private static final String SUBJECT = "myxym";

    public static String geneJsonWebToken(User user) {

        if (user == null || user.getHeadImg() == null || user.getId() == null || user.getName() == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                //发行时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();

        token = TOKEN_PREFIX + token;
        return token;

    }

    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

}
