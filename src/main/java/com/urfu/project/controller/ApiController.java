package com.urfu.project.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public/info")
    public String publicInfo() {
        return "Публичный API";
    }

    @GetMapping("/admin/data")
    @RolesAllowed("ADMIN")
    public String adminData(@AuthenticationPrincipal UserDetails userDetails) {
        return String.format("Админ. Пользователь: %s, Роль: %s",
                userDetails.getUsername(),
                userDetails.getAuthorities());
    }

    @GetMapping("/support/data")
    @RolesAllowed("SUPPORT")
    public String supportData(@AuthenticationPrincipal UserDetails userDetails) {
        return String.format("Саппорт. Пользователь: %s, Роль: %s",
                userDetails.getUsername(),
                userDetails.getAuthorities());
    }
}
