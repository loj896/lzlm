package com.lzlm.cn.dao.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzlm.cn.dto.user.UserRoleDto;
import com.lzlm.cn.model.user.UserRoleRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleRelMapper extends BaseMapper<UserRoleRel> {

    /**
     * 根据用户ID查询用户角色
     * @param userId
     * @return
     */
    List<UserRoleDto> getUserRole(@Param("userId") String userId);
}