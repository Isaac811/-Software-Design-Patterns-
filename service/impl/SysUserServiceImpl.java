package com.work.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.domain.SysUser;
import com.work.domain.request.AddUserRQ;
import com.work.service.SysUserService;
import com.work.mapper.SysUserMapper;
import com.work.util.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * @author Jiayu Liu
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public void add(AddUserRQ rq) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(rq.getUserName());
        sysUser.setPassword(rq.getPassword());
        save(sysUser);
    }

    @Override
    public SysUser getByUserName(String userName) {
        return getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName,userName));
    }

    @Override
    public SysUser getUser() {
        String userName = (String) SecurityUtils.getAuthentication().getPrincipal();
        return getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName,userName));
    }
}




