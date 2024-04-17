package com.work.service.impl;

import com.work.domain.SysUser;
import com.work.domain.request.LoginRQ;
import com.work.service.LoginService;
import com.work.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Jiayu Liu
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(LoginRQ rq) {
        SysUser user = new SysUser();
        user.setUserName(rq.getUserName());
        user.setPassword(passwordEncoder.encode(rq.getPassword()));
        sysUserService.save(user);
    }
}
