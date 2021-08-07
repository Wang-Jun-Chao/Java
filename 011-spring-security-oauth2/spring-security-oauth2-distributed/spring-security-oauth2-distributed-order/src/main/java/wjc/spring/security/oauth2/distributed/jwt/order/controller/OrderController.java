package wjc.spring.security.oauth2.distributed.jwt.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wjc.spring.security.oauth2.distributed.jwt.order.model.UserDto;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class OrderController {

    @PreAuthorize("hasAuthority('p1')")
    @GetMapping(value = "/r1")
    public String r1() {
        //通过Spring Security API获取当前登录用户
        UserDto user = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername() + "访问资源1";
    }

    @PreAuthorize("hasAuthority('p2')")
    @GetMapping(value = "/r2")
    public String r2() {
        //通过Spring Security API获取当前登录用户
        UserDto user = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername() + "访问资源2";
    }

}