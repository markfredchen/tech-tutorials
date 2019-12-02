package tech.markfredchen.tech.samples.spring.cloud.zipkin.bar.service.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author markfredchen
 * @since 2019/11/26
 */
@Slf4j
@RestController
class BarRestController {
    @GetMapping("/api/bar/{message}")
    public Map<String, String> showMessage(@PathVariable String message) {
        log.info("Bar Service Received: {}", message);
        Map<String, String> result = new HashMap<>(2);
        result.put("result", message);
        result.put("service", "barService");
        return result;
    }

}
