package com.urfu.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HeadersController {

    @GetMapping("/headers")
    public String showHeaders(HttpServletRequest request, Model model) {
        try {
            Map<String, String> headers = Collections.list(request.getHeaderNames())
                    .stream()
                    .collect(Collectors.toMap(
                            name -> name,
                            request::getHeader
                    ));
            model.addAttribute("headers", headers);
            return "headers-view";
        } catch (Exception e) {
            throw new RuntimeException("Failed to process headers", e);
        }
    }
}
