package tech.markfredchen.persistence.mybatis.plus.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.markfredchen.persistence.mybatis.plus.entity.User;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author markfredchen
 * @since 2019/12/5
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testCRUD() {
        List<User> userList = userService.list();
        assertThat(userList).isNotNull();
        assertThat(userList).isEmpty();
        User user = new User();
        user.setUsername("test_user");
        user.setPhone("test_phone");

        userService.save(user);
        User persisted = userService.getById(user.getId());
        assertThat(persisted.getIsEnabled()).isTrue();
        assertThat(persisted.getIsDeleted()).isFalse();

        // 更新时，如果字段为null，则不对字段进行更新。
        User toUpdate = new User();
        toUpdate.setId(user.getId());
        toUpdate.setUsername("update_user");
        userService.updateById(toUpdate);


        persisted = userService.getById(user.getId());
        assertThat(persisted.getUsername()).isEqualTo("update_user");
        assertThat(persisted.getPhone()).isEqualTo("test_phone");
        assertThat(persisted.getIsEnabled()).isTrue();
        assertThat(persisted.getIsDeleted()).isFalse();

        // 查询新写法
        User findByPhone = userService.lambdaQuery().eq(User::getPhone, "test_phone").one();
        assertThat(findByPhone).isEqualTo(persisted);

        User findByPhoneNotExists = userService.lambdaQuery().eq(User::getPhone, "wrong_phone").one();
        assertNull(findByPhoneNotExists);

        findByPhone = userService.query().eq("phone", "test_phone").one();
        assertThat(findByPhone).isEqualTo(persisted);

        findByPhoneNotExists = userService.query().eq("phone", "wrong_phone").one();
        assertNull(findByPhoneNotExists);

        // 逻辑删除
        userService.removeById(user.getId());
        User removed = jdbcTemplate.queryForObject("select * from mp_user where id = " + user.getId(), (RowMapper<User>) (rs, rowNum) -> {
            User u = new User();
            u.setId(rs.getLong("id"));
            u.setUsername(rs.getString("username"));
            u.setPhone(rs.getString("phone"));
            u.setIsEnabled(rs.getBoolean("is_enabled"));
            u.setIsDeleted(rs.getBoolean("is_deleted"));
            u.setCreatedDate(ZonedDateTime.ofInstant(new Date(rs.getDate("created_date").getTime()).toInstant(), ZoneId.systemDefault()));
            return u;
        });
        assertNotNull(removed);
        assertThat(removed.getIsDeleted()).isTrue();


    }
}