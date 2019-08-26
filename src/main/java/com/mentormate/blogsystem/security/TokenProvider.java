//package com.mentormate.blogsystem.security;
//
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.PostConstruct;
//
//
//@Component
//public class TokenProvider implements InitializingBean {
//
//    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
//
//    private static final String AUTHORITIES_KEY = "auth";
//
//    private Key key;
//
//    private final long tokenValidityInMilliseconds;
//
//    private final long tokenValidityInMillisecondsForRememberMe;
//
//    private final String jwtSecret;
//
//    public TokenProvider(@Value("${security.jwt.token.validity}") Long tokenValidity, @Value("${security.jwt.token.validity.remember.me}") Long tokenValidityForRememberMe,
//                         @Value("${security.jwt.secret}") String jwtSecret) {
//        this.tokenValidityInMilliseconds = tokenValidity * 1000;
//        this.tokenValidityInMillisecondsForRememberMe = tokenValidityForRememberMe * 1000;
//        this.jwtSecret = jwtSecret;
//    }
//
//
//    @PostConstruct
//    public void afterPropertiesSet() throws Exception {
//         var keyBytes = Decoders.BASE64.decode(this.jwtSecret);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    public String createToken(Authentication authentication, boolean rememberMe) {
//        String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//
//        long now = (new Date()).getTime();
//        Date validity;
//        if (rememberMe) {
//            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
//        } else {
//            validity = new Date(now + this.tokenValidityInMilliseconds);
//        }
//
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim(AUTHORITIES_KEY, authorities)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .setExpiration(validity)
//                .compact();
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(token)
//                .getBody();
//
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        User principal = new User(claims.getSubject(), "", authorities);
//
//        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
//            return true;
//        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
//            log.info("Invalid JWT signature.");
//            log.trace("Invalid JWT signature trace: {}", e);
//        } catch (ExpiredJwtException e) {
//            log.info("Expired JWT token.");
//            log.trace("Expired JWT token trace: {}", e);
//        } catch (UnsupportedJwtException e) {
//            log.info("Unsupported JWT token.");
//            log.trace("Unsupported JWT token trace: {}", e);
//        } catch (IllegalArgumentException e) {
//            log.info("JWT token compact of handler are invalid.");
//            log.trace("JWT token compact of handler are invalid trace: {}", e);
//        }
//        return false;
//    }
//}
