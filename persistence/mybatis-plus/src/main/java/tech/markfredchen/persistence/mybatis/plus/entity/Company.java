package tech.markfredchen.persistence.mybatis.plus.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import tech.markfredchen.persistence.mybatis.plus.persistence.typehanlder.JSONObjectTypeHandler;

/**
 * @author markfredchen
 * @since 2019/12/6
 */
@Data
@TableName("mp_company")
public class Company {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @TableField(value = "company_name")
    private String name;
    @TableField(value = "config", typeHandler = JSONObjectTypeHandler.class)
    private JSONObject config;
    @Version
    private Integer version;
}
