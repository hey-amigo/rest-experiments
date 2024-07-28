package it.is.beautiful.experiments.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestClientController {

    String SERVER_URL = "http://localhost:8080/v1/api/hello";
    RestClient restClient;

    @GetMapping("/rest-client")
    public String test() {
        return restClient.get()
                .uri(SERVER_URL)
                .retrieve()
                .body(String.class);
    }
}
