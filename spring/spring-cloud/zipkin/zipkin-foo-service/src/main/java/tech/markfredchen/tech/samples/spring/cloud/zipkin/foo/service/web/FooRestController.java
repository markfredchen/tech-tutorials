package tech.markfredchen.tech.samples.spring.cloud.zipkin.foo.service.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author markfredchen
 * @since 2019/11/26
 */
@Slf4j
@RestController
class FooRestController {
    private final RestTemplate restTemplate;

    FooRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/api/foo/{message}")
    public JSONObject showMessage(@PathVariable String message) {
        log.info("Foo Service Sent: {}", message);
        return JSON.parseObject(this.restTemplate.getForObject("http://localhost:20000/bar/api/bar/" + message, String.class));
    }
}
