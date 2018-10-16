package com.guofei.wu.config;

import com.guofei.wu.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 吴国飞 (guofei.wu)
 * @author 吴国飞 (guofei.wu)
 * @version 2018/9/28
 * @since 2018/9/28
 */
@Configuration
public class UserBean {
    @Bean
    public User newUser() {
        return new User("a", 1);
    }
}
