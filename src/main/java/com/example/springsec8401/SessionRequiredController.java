/**
 * Copyright (c) Coveo Solutions Inc.
 */
package com.example.springsec8401;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionRequiredController
{
    private static final String SESSION_KEY = SessionRequiredController.class.getName();
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(path = "/session/ping")
    public String api()
    {
        String sessionValue = (String) httpSession.getAttribute(SESSION_KEY);

        if (sessionValue == null) {
            sessionValue = UUID.randomUUID().toString();
            httpSession.setAttribute(SessionRequiredController.class.getName(), sessionValue);
        }

        return sessionValue;
    }
}
