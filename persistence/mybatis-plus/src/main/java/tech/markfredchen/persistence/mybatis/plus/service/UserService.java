package tech.markfredchen.persistence.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.markfredchen.persistence.mybatis.plus.entity.User;
import tech.markfredchen.persistence.mybatis.plus.persistence.UserMapper;

/**
 * @author markfredchen
 * @since 2019/12/5
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
