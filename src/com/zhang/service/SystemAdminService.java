package com.zhang.service;

import com.zhang.dto.SystemAdminDto;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:40
 * @Description: TODO
 * @Version: 1.0
 */
public interface SystemAdminService {
    public SystemAdminDto login(String username,String password);
}
