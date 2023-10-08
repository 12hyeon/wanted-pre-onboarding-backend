package com.example.wantedpreonboardingbackend.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("swagger")
    public String redirectSwagger2() {
        return "redirect:/swagger-ui/index.html";
    }
}