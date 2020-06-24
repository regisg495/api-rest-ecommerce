package com.ecommercerest.config.security;

import com.ecommercerest.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.function.Function;

@Component
public class AuthenticationTokenProvider {

    @Value("${ecommerce.rest.jwt.expiration}")
    private String expiration;

    @Value("${ecommerce.rest.jwt.key}")
    private String key;

    private static final String ISSUER = "ecommerce-rest";

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public String createToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + Long.parseLong(this.expiration));

        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();

    }

    public Authentication getAuthentication(String token) {
        Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(this.key).parseClaimsJws(token).getBody().getSubject();
    }

    public String recoverToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) return null;

        return token.substring(7);

    }

    public boolean isValidToken(String token) {

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(this.key).parseClaimsJws(token);

        if (claimsJws.getBody().getExpiration().before(new Date()) || token == null) return false;

        return true;

    }
}
