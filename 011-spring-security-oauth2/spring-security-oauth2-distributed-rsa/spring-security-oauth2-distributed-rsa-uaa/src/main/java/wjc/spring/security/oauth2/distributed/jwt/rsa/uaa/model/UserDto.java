package wjc.spring.security.oauth2.distributed.jwt.rsa.uaa.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {
    private String id;
    private String username;
    @JsonIgnore
    @JSONField(serialize = false)
    private String password;
    private String fullname;
    private String mobile;
}
