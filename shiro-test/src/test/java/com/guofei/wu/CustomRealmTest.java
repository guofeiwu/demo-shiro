package com.guofei.wu;

import com.guofei.wu.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/10/12
 * @since 2018/10/12
 */
public class CustomRealmTest {
    @Test
    public void authenticationTest() {

        CustomRealm customRealm = new CustomRealm();


        // 构建security manager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        // security manager 设置realm
        defaultSecurityManager.setRealm(customRealm);

        // 设置security manager
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        // 构建认证主体
        Subject subject = SecurityUtils.getSubject();

        // 构建认证的token
        AuthenticationToken token = new UsernamePasswordToken("jack", "123456");


        System.out.println("isAuthenticated：" + subject.isAuthenticated());

        // 登陆
        subject.login(token);

        System.out.println("isAuthenticated：" + subject.isAuthenticated());


        subject.checkRole("admin");
        subject.checkRoles("admin", "user");


        subject.checkPermission("user:delete");
        subject.checkPermissions("user:select", "user:delete");


    }
}
