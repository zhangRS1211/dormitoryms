package com.zhang.service.impl;

import com.zhang.dao.SystemAdminDao;
import com.zhang.dao.impl.SystemAdminDaoImpl;
import com.zhang.dto.SystemAdminDto;
import com.zhang.entity.SystemAdmin;
import com.zhang.service.SystemAdminService;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:46
 * @Description: TODO
 * @Version: 1.0
 */
public class SystemAdminServiceImpl implements SystemAdminService {
    private SystemAdminDao systemAdminDao = new SystemAdminDaoImpl();

    @Override
    public SystemAdminDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，判断password是否正确
        SystemAdmin systemAdmin = this.systemAdminDao.findByUsername(username);
        SystemAdminDto systemAdminDto = new SystemAdminDto();

        if (systemAdmin == null){
            systemAdminDto.setCode(-1); //-1表示用户名不存在
        }else{
            if (!systemAdmin.getPassword().equals(password)){
                systemAdminDto.setCode(-2); //-2表示用户名存在，密码不存在
            }else{
                systemAdminDto.setCode(0);  // 0表示登录成功
                systemAdminDto.setSystemAdmin(systemAdmin);
            }
        }
        return systemAdminDto;
    }
}
