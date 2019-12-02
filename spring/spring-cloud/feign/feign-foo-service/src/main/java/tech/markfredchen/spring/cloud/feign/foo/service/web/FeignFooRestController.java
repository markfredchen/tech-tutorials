package tech.markfredchen.spring.cloud.feign.foo.service.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.markfredchen.spring.cloud.feign.foo.service.client.BarClient;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@RestController
public class FeignFooRestController {
    private final BarClient barClient;

    public FeignFooRestController(BarClient barClient) {
        this.barClient = barClient;
    }

    @GetMapping("/api/foo/{fooMessage}/{barMessage}")
    public JSONObject showMessage(@PathVariable String fooMessage, @PathVariable String barMessage) {
        JSONObject bar = barClient.showMessage(barMessage);
        bar.put("fooMessage", fooMessage);
        return bar;
    }
}
