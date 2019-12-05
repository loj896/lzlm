package com.lzlm.cn.dao.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzlm.cn.dto.role.RoleAuthDto;
import com.lzlm.cn.model.role.RoleAuthRel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleAuthRelMapper extends BaseMapper<RoleAuthRel> {

    /**
     * 根据角色ID查询权限
     * @param roleId
     * @return
     */
    List<RoleAuthDto> getAuthByRoleId(@Param("roleId") String roleId);
}