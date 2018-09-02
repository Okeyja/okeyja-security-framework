package cn.okeyja.mysecurity.userservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class WebController {
    @GetMapping("")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String foo() {

        return "Welcome, " + SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
