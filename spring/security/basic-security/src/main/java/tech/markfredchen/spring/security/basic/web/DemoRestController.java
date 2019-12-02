package tech.markfredchen.spring.security.basic.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author markfredchen
 * @since 2019/11/27
 */
@RestController
public class DemoRestController {
    @GetMapping("/api/demo")
    @Secured("ROLE_ADMIN")
    public String greeting() {
        return "Hello World";
    }


    @GetMapping("/api/public/api")
    public String publicAPI() {
        return "this is public API";
    }
}
