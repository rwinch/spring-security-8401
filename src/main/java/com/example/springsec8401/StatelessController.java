/**
 * Copyright (c) Coveo Solutions Inc.
 */
package com.example.springsec8401;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatelessController
{
    @RequestMapping(path = "/stateless/ping")
    public String api()
    {
        return "pong";
    }
}
