package tech.markfredchen.persistence.mybatis.plus.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.markfredchen.persistence.mybatis.plus.entity.Company;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author markfredchen
 * @since 2019/12/6
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void testVersionUpdate() {
        Company company = new Company();
        company.setName("test_com");
        company.setVersion(1);
        JSONObject config = new JSONObject();
        config.put("test", "test");
        company.setConfig(config);
        companyService.save(company);

        company.setName("update_com");
        company.setVersion(1);
        companyService.updateById(company);

        Company persisted = companyService.getById(company.getId());
        assertThat(persisted.getVersion()).isEqualTo(2);
        assertThat(persisted.getName()).isEqualTo("update_com");

        Company toUpdate = new Company();
        toUpdate.setId(company.getId());
        toUpdate.setName("update");
        toUpdate.setVersion(2);

        companyService.updateById(toUpdate);

        persisted = companyService.getById(company.getId());
        assertThat(persisted.getVersion()).isEqualTo(3);
        assertThat(persisted.getName()).isEqualTo("update");

        List<Company> searched = companyService.searchCompany("update");
        assertThat(searched.size()).isEqualTo(1);


    }


}