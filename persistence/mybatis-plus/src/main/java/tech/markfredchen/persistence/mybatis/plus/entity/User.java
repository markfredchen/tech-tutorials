package tech.markfredchen.persistence.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * @author markfredchen
 * @since 2019/12/5
 */
@Data
@TableName("mp_user")
public class User {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String phone;
    private Boolean isEnabled;
    @TableLogic
    private Boolean isDeleted;
    private ZonedDateTime createdDate;
}
