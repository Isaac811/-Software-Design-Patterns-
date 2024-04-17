/**
 *
 */
package com.work.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.domain.Admin;
import com.work.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jiayu Liu
 * @date Jiayu Liu-3-9
 */
@Service
@Transactional
public class AdminService extends ServiceImpl<AdminMapper, Admin> {


    public void insert(Admin admin) {
        save(admin);
    }


}
