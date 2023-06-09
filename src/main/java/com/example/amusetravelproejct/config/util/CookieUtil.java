package com.example.amusetravelproejct.config.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.SerializationUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Optional;

@Slf4j
public class CookieUtil {

    public static Optional<Cookie> getCookie(HttpServletRequest request, String name) {
        log.info("CookieUtill 에서 getCookie 실행");
        Cookie[] cookies = request.getCookies();
        log.info("cookies : " + cookies);

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookie의 이름은" + cookie.getName());
                if (name.equals(cookie.getName())) {
                    return Optional.of(cookie);
                }
            }
        }
        return Optional.empty();
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        log.info("\n\nCookieUtil 에서 addCookie 진입");
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);

        log.info("cookie : ");
        log.info(cookie.getValue());
        log.info(cookie.getName());
        log.info(cookie.getComment());
        log.info(cookie.getPath());
        log.info(cookie.getDomain());
        log.info(String.valueOf(cookie.getMaxAge()));
        log.info(String.valueOf(cookie.getSecure()));
        log.info(String.valueOf(cookie.getVersion()));
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        log.info("\n\nCookieUtil 에서 deleteCookie");

        Cookie[] cookies = request.getCookies();
        log.info("cookies : " + cookies);


        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                log.info(cookie.getName());
                if (name.equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }

    public static String serialize(Object obj) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(obj));
    }

    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }

}
