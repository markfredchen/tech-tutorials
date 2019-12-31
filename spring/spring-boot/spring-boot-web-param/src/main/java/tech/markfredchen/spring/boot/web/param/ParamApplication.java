package tech.markfredchen.spring.boot.web.param;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author markfredchen
 * @since 2019/12/4
 */
@SpringBootApplication
public class ParamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParamApplication.class);
    }
}

@Slf4j
@RestController
class ParamRestController {
    @GetMapping("/api/list")
    public List<Sort> getSorts(PageRequest pageRequest) {
        log.info("sort is null: {}", pageRequest.getSorts() == null);
        return pageRequest.getSorts();
    }

    @GetMapping("/api/obj")
    public Sort getSorts(Sort sort) {
        return sort;
    }
}

@Data
class PageRequest {
    List<Sort> sorts;
}

@Data
class Sort {
    private String property;
    private Direction direction;
}

enum Direction {
    /**
     * 升序
     */
    ASC,
    /**
     * 降序
     */
    DESC;
}