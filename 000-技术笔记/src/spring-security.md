# UserDetailService

用于用户认证



# PasswordEncoder

用于密码加密



用户名密码验证三种方式

- 使用配置文件

```yml
spring:
  security:
    user:
      name: jack
      password: rose
```

- 使用配置类

```java
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123");
        auth.inMemoryAuthentication().withUser("luch").password(password).roles("admin");
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
```

- 自定义实现类

  - 创建配置类，实现UserDetailService

  ```java
  @Configuration
  public class SecurityCustomConfig extends WebSecurityConfigurerAdapter {
  
      @Autowired
      private UserDetailsService userDetailsService;
  
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userDetailsService).passwordEncoder(password());
      }
  
      @Bean
      PasswordEncoder password() {
          return new BCryptPasswordEncoder();
      }
  }
  ```

  

  - 编写实现类，返回User对象，User对象有用户名密码和操作权限

  ```java
  @Service("userDetailsService")
  public class MyUserDetailsServiceImpl implements UserDetailsService {
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
          return new User("mary", new BCryptPasswordEncoder().encode("123"), auths);
  
      }
  }
  ```

