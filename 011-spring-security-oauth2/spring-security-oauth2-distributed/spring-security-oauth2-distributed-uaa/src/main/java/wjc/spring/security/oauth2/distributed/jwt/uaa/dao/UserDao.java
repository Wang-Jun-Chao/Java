package wjc.spring.security.oauth2.distributed.jwt.uaa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import wjc.spring.security.oauth2.distributed.jwt.uaa.model.PermissionDto;
import wjc.spring.security.oauth2.distributed.jwt.uaa.model.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据账号查询用户信息
    public UserDto getUserByUsername(String username) {
        String sql = "select id,username,password,fullname,mobile from t_user where username = ?";
        //连接数据库查询用户
        List<UserDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDto.class), username);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    //根据用户id查询用户权限
    public List<String> findPermissionsByUserId(String userId) {
        String sql = "SELECT * FROM t_permission WHERE id IN(\n" +
                "\n" +
                "SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" +
                "  SELECT role_id FROM t_user_role WHERE user_id = ? \n" +
                ")\n" +
                ")\n";

        List<PermissionDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PermissionDto.class), userId);
        List<String> permissions = new ArrayList<>();
        list.forEach(c -> permissions.add(c.getCode()));
        return permissions;
    }
}
