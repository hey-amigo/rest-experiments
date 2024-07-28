package it.is.beautiful.experiments.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestTemplateController {


    String SERVER_URL = "http://localhost:8080/v1/api/hello";
    RestTemplate restTemplate;


    @GetMapping("/rest-template")
    public String test() {
        var response = restTemplate.getForObject(SERVER_URL, String.class);
        log.debug("Server response={}", response);
        return response;
    }
}
