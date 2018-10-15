package com.guofei.wu.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/9/30
 * @since 2018/9/30
 */
public class LocalUserDetail implements UserDetails {


    private String username;
    private String fullname;
    private String password;

    public LocalUserDetail(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // 实现的方法

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
