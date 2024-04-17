package com.work.util;

import com.alibaba.fastjson2.JSON;

import java.util.List;

/**
 * @author Jiayu Liu
 */
public class MapStruct {

    public static <T,S> List<T> convert(List<S> list,Class<T> tClass){
        return JSON.parseArray(JSON.toJSONString(list),tClass);
    }

    public static <T,S> T convert(S s,Class<T> tClass){
        return JSON.parseObject(JSON.toJSONString(s),tClass);
    }
}
