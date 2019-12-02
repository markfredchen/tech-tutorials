package tech.markfredchen.spring.cloud.consul.foo.service.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@FeignClient("consul-bar-service/consul-bar")
public interface BarClient {
    @GetMapping("/api/bar/{message}")
    JSONObject showMessage(@PathVariable("message") String message);
}
