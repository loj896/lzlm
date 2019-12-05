package com.lzlm.cn.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/***
 *                    .::::. 
 *                  .::::::::. 
 *                 :::::::::::        @author liuhai
 *             ..:::::::::::'         @date 2019-12-02 11:23
 *           '::::::::::::'           @description 对象转换
 *             .:::::::::: 
 *        '::::::::::::::.. 
 *             ..::::::::::::. 
 *           ``:::::::::::::::: 
 *            ::::``:::::::::'        .:::. 
 *           ::::'   ':::::'       .::::::::. 
 *         .::::'      ::::     .:::::::'::::. 
 *        .:::'       :::::  .:::::::::' ':::::. 
 *       .::'        :::::.:::::::::'      ':::::. 
 *      .::'         ::::::::::::::'         ``::::. 
 *  ...:::           ::::::::::::'              ``::. 
 * ```` ':.          ':::::::::'                  ::::.. 
 *                    '.:::::'                    ':'````.. 
 */
public class BeanConvert {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 集合转换
     * @param sourceArray
     * @param target
     * @param <S> 源数据集合
     * @param <T> 转换后集合中的对象类型
     * @return
     */
    public static <S,T> List<T> listConvert(List<S> sourceArray, Class<T> target){
        List<T> restList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(sourceArray)){
            for (S s : sourceArray){
                restList.add(mapper.convertValue(s, target));
            }
        }
        return restList;
    }

    /**
     * 单个对象转换
     * @param sourceBean
     * @param target
     * @param <S> 源数据对象
     * @param <T> 转换后的类型
     * @return
     */
    public static <S,T> T beanConvert(S sourceBean, Class<T> target){
        if(null != sourceBean){
            return  mapper.convertValue(sourceBean, target);
        }
        return null;
    }


}
