package com.agt.technology.util.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Slf4j
public class JwtUtils {

    @Resource
    private JwtProperties jwtProperties;

    public String generateJwtToken(Authentication authentication) {
        String compact = Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (jwtProperties.getTtl() * 3600000)))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
        log.info("用户【" + authentication.getName() + "】的jwt token 为" + compact);
        return compact;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }

}
