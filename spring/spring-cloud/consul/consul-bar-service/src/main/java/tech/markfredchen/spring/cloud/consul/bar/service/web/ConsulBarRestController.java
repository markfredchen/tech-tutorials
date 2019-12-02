package tech.markfredchen.spring.cloud.consul.bar.service.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@RestController
public class ConsulBarRestController {
    @GetMapping("/api/bar/{message}")
    public JSONObject showMessage(@PathVariable String message) {
        JSONObject result = new JSONObject();
        result.put("message", message);
        return result;
    }
}
