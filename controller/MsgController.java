package com.work.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.work.domain.Msg;
import com.work.domain.SysUser;
import com.work.domain.response.MsgRS;
import com.work.service.MsgService;
import com.work.service.SysUserService;
import com.work.util.MapStruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jiayu Liu
 */
@Slf4j
@Controller
@RequestMapping(value = "/msg")
public class MsgController {

    @Resource
    private MsgService msgService;

    @Resource
    private SysUserService userService;

    @GetMapping("/page")
    public ModelAndView page(ModelAndView model) {
        model.setViewName("msg/msgList");
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<MsgRS> listProduct() {
        SysUser user = userService.getUser();
        List<Msg> list = msgService.list(Wrappers.<Msg>lambdaQuery().eq(Msg::getUserId, user.getId()));
        return MapStruct.convert(list, MsgRS.class);
    }
}
