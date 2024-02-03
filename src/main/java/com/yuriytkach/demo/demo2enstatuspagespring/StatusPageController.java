package com.yuriytkach.demo.demo2enstatuspagespring;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StatusPageController {

    public static final String DEFAULT_IP = "56.23.45.50";


    private final StatusService statusService;

    @GetMapping(value = "/", produces = "text/html")
    public ModelAndView get(
      @RequestHeader(value = "X-Forwarded-For", required = false) final String xForwardedFor
    ) {
        final String ip = xForwardedFor == null ? DEFAULT_IP : xForwardedFor.split(",")[0];
        final var data = statusService.loadData(ip);
        return new ModelAndView("home", Map.of("data", data));
    }

}
