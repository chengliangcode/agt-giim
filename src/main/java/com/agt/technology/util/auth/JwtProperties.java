package com.agt.technology.util.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "agt.security.jwt")
//@EnableConfigurationProperties(JwtProperties.class)
public class JwtProperties {

    /**
     * JWT加密秘钥信息
     */
    private String secret;

    /**
     * Token过期时间，单位小时 ，默认8小时
     */
    private Integer ttl = 8;

    /**
     * token的签发者
     */
    private String issuer;

    /**
     * token名称；accessToken
     */
    private String name;

}