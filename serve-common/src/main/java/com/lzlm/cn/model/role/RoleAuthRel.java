package com.lzlm.cn.model.role;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_role_auth_rel")
public class RoleAuthRel {

    @TableId
    private String roleAuthId;

    private String roleId;

    private String authId;

    private Integer relState;

    public String getRoleAuthId() {
        return roleAuthId;
    }

    public void setRoleAuthId(String roleAuthId) {
        this.roleAuthId = roleAuthId == null ? null : roleAuthId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId == null ? null : authId.trim();
    }

    public Integer getRelState() {
        return relState;
    }

    public void setRelState(Integer relState) {
        this.relState = relState;
    }
}