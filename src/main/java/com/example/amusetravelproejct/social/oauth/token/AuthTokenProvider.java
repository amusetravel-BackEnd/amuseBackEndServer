package com.example.amusetravelproejct.social.oauth.token;

import com.example.amusetravelproejct.social.oauth.exception.TokenValidFailedException;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Key;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class AuthTokenProvider {

    private final Key key;
    private static final String AUTHORITIES_KEY = "role";


    private final UserDetailsService userDetailService;

    public AuthTokenProvider(String secret, UserDetailsService userDetailService) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.userDetailService = userDetailService;
    }

    public AuthToken createAuthToken(String id, Date expiry) {
        System.out.println("\n\nAuthTokenProvider 에서 createAuthToken");
        System.out.println("key : " + key);
        return new AuthToken(id, expiry, key);
    }

    public AuthToken createAuthToken(String id, String role, Date expiry) {
        return new AuthToken(id, role, expiry, key);
    }

    public AuthToken convertAuthToken(String token) {
        return new AuthToken(token, key);
    }

    public Authentication getAuthentication(AuthToken authToken) {
        System.out.println("AuthTokenProvider 에서 getAuthentication");
        if(authToken.validate()) {

//            Claims claims = authToken.getTokenClaims();
//            Collection<? extends GrantedAuthority> authorities =
//                    Arrays.stream(new String[]{claims.get(AUTHORITIES_KEY).toString()})
//                            .map(SimpleGrantedAuthority::new)
//                            .collect(Collectors.toList());
//
//            log.debug("claims subject := [{}]", claims.getSubject());
//            User principal = new User(claims.getSubject(), "", authorities);

            UserDetails userDetails = userDetailService.loadUserByUsername(authToken.getTokenClaims().getSubject());
            return new UsernamePasswordAuthenticationToken(userDetails, authToken, userDetails.getAuthorities());
        } else {
            throw new TokenValidFailedException();
        }
    }

}
