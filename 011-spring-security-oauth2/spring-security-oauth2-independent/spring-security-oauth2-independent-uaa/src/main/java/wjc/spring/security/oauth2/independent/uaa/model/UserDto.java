package wjc.spring.security.oauth2.independent.uaa.model;

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
    private String password;
    private String fullname;
    private String mobile;
}
