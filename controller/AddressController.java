package com.work.controller;

import com.work.domain.UserAddress;
import com.work.domain.request.UserAddressRQ;
import com.work.domain.response.AddressRQ;
import com.work.service.SysUserService;
import com.work.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Jiayu Liu
 */
@Slf4j
@Controller
@RequestMapping("/address")
public class AddressController {

    @Resource
    private UserAddressService addressService;

    @Resource
    private SysUserService userService;

    @GetMapping("/list")
    @ResponseBody
    public List<AddressRQ> list(){
        return addressService.getAddress();
    }

    @GetMapping("/detail")
    @ResponseBody
    public UserAddress detail(Integer id){
        return addressService.getById(id);
    }

    @PostMapping("/insert")
    public void insert(@RequestBody UserAddressRQ rq){
        UserAddress address = new UserAddress();
        address.setConsignee(rq.getConsignee());
        address.setPhone(rq.getPhone());
        address.setAddress(rq.getAddress());
        if (Objects.nonNull(rq.getId())){
            address.setId(rq.getId());
            address.setUpdateTime(LocalDateTime.now());
        }else{
            address.setCreateTime(LocalDateTime.now());
        }
        address.setUserId(userService.getUser().getId());
        addressService.saveOrUpdate(address);
    }

    @PutMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        addressService.removeById(id);
    }
}
