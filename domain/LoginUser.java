package com.work.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Jiayu Liu
 */
@Setter
public class LoginUser implements UserDetails {

    private Integer userId;

    private String userName;

    private SysUser user;

    private List<? extends GrantedAuthority> grantedAuthoritys;

    @Getter
    private String token;

    @Getter
    private Long expireTime;

    @Getter
    private Long loginTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthoritys;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
