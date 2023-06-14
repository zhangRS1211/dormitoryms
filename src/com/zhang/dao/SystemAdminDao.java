package com.zhang.dao;

import com.zhang.entity.SystemAdmin;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.dao
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:48
 * @Description: TODO
 * @Version: 1.0
 */
public interface SystemAdminDao {
    public SystemAdmin findByUsername(String username);
}
