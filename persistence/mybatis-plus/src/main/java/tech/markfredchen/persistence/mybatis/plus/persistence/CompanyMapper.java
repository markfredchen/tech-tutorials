package tech.markfredchen.persistence.mybatis.plus.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import tech.markfredchen.persistence.mybatis.plus.entity.Company;

import java.util.List;

/**
 * @author markfredchen
 * @since 2019/12/6
 */
public interface CompanyMapper extends BaseMapper<Company> {
    List<Company> searchCompany(@Param("keyword") String keyword);

}
