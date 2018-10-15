package com.guofei.wu.service.impl;

import com.guofei.wu.model.User;
import com.guofei.wu.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/9/28
 * @since 2018/9/28
 */
@Service
public class UserServiceImpl implements UserService {

    private final User user;

    public UserServiceImpl(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }

}
