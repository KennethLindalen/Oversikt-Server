package dev.kennethlindalen.rkupongoversikt.Security.JWT.Utils;

import org.springframework.beans.factory.annotation.Value;

public class JWTContstants {

    public static final long TOKEN_VALIDITY = 10 * 60 * 60;

    @Value("${secret}")
    public static String JWT_SECRET;

}
