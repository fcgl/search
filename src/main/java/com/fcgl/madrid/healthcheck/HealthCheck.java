package com.fcgl.madrid.healthcheck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheck {

    @RequestMapping("/v1/marco")
    @ResponseStatus(HttpStatus.OK)
    public Health checkHealth() {
        return new Health(1, "search");
    }
}

