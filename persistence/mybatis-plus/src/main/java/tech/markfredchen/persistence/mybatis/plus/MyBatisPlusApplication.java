package tech.markfredchen.persistence.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author markfredchen
 * @since 2019/12/5
 */
@SpringBootApplication
@MapperScan("tech.markfredchen.persistence.mybatis.plus.persistence")
public class MyBatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class);
    }

}
