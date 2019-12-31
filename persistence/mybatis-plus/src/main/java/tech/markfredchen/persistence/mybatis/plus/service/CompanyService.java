package tech.markfredchen.persistence.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.markfredchen.persistence.mybatis.plus.entity.Company;
import tech.markfredchen.persistence.mybatis.plus.persistence.CompanyMapper;

import java.util.List;

/**
 * @author markfredchen
 * @since 2019/12/6
 */
@Service
public class CompanyService extends ServiceImpl<CompanyMapper, Company> {
    List<Company> searchCompany(String keyword) {
        return baseMapper.searchCompany(keyword);
    }
}
