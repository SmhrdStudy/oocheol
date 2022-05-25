package com.smart.project.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    private static final String CONTEXT_DOMAIN = "localhost";
    private static final int CONTEXT_AGE = 60 * 60 * 24; // 하루

    public static void createCookie(HttpServletResponse res, String name, String value){
        Cookie c = new Cookie(name, value);
        c.setComment(name);
        c.setPath("/");
        c.setDomain(CONTEXT_DOMAIN);
        c.setMaxAge(CONTEXT_AGE);
        res.addCookie(c);
    }
}

