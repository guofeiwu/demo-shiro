package com.guofei.wu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 吴国飞 (guofei.wu)
 * @author 吴国飞 (guofei.wu)
 * @version 2018/9/30
 * @since 2018/9/30
 */
@Component
@ConfigurationProperties(prefix = "my")
public class PropertiesConfig {
    private String name;
    private int old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
