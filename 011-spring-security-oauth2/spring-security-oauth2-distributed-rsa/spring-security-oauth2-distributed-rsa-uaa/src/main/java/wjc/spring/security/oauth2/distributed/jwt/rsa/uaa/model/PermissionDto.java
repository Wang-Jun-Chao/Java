package wjc.spring.security.oauth2.distributed.jwt.rsa.uaa.model;

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
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
