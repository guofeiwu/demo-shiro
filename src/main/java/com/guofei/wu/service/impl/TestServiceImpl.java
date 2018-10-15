package com.guofei.wu.service.impl;

import com.guofei.wu.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/10/8
 * @since 2018/10/8
 */
@Service
public class TestServiceImpl implements TestService {
    Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public boolean test() {
        logger.info("this is test");
        return false;
    }
}
