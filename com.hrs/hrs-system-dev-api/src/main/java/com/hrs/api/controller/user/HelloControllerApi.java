package com.hrs.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

public interface HelloControllerApi {
    @GetMapping("/Hello")
    public Object hello();
}
