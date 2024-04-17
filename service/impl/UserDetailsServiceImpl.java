package com.work.service.impl;

import com.work.domain.SysRole;
import com.work.domain.SysUser;
import com.work.service.SysRoleService;
import com.work.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Jiayu Liu
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(userName)) {
            throw new RuntimeException("userName is not null");
        }
        SysUser user = sysUserService.getByUserName(userName);
        if (Objects.isNull(user)) {
            throw new RuntimeException("user not exist");
        }
        SysRole role = roleService.getById(user.getRoleId());
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
        return new User(user.getUserName(), user.getPassword(), Collections.singleton(simpleGrantedAuthority));
//        LoginUser loginUser = new LoginUser();
//        loginUser.setUserId(user.getId());
//        loginUser.setUserName(user.getUserName());
//        loginUser.setRoleName(role.getName());
//        loginUser.setGrantedAuthoritys(Collections.singletonList(simpleGrantedAuthority));
//        return loginUser;
    }
}
