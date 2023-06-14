package com.zhang.dto;

import com.zhang.entity.SystemAdmin;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.dto
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:42
 * @Description: TODO
 * @Version: 1.0
 */
public class SystemAdminDto {
    private Integer code;
    private SystemAdmin systemAdmin;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }
}
