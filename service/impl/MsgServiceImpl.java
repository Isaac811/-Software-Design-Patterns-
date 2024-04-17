package com.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.work.domain.Msg;
import com.work.service.MsgService;
import com.work.mapper.MsgMapper;
import org.springframework.stereotype.Service;

/**
 * @author Jiayu Liu
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg>
    implements MsgService{

}




