package com.guofei.wu;

import com.guofei.wu.config.PropertiesListener;
import com.guofei.wu.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * @author guofei.wu
 */
@SpringBootApplication
public class DemoSpringbootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoSpringbootApplication.class);
    }

    public static void main(String[] args) {
//        SpringApplication.run(DemoSpringbootApplication.class,args);
        SpringApplication application = new SpringApplication(DemoSpringbootApplication.class);
        // 第四种方式：注册监听器
        application.addListeners(new PropertiesListener("app-config.properties"));
        application.run(args);
    }

}
