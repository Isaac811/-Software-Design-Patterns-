package com.work.controller;

import com.work.domain.request.LoginRQ;
import com.work.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Jiayu Liu
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Operation(summary = "register")
    @PostMapping("/register")
    private void register(@RequestBody LoginRQ rq) {
        loginService.register(rq);
    }

}
