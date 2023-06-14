package com.zhang.service.impl;

import com.zhang.dao.DormitoryAdminDao;
import com.zhang.dao.impl.DormitoryAdminDaoImpl;
import com.zhang.dto.DormitoryAdminDto;
import com.zhang.entity.DormitoryAdmin;
import com.zhang.service.DormitoryAdminService;

import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-12  14:51
 * @Description: TODO
 * @Version: 1.0
 */
public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    private DormitoryAdminDao dormitoryAdminDao = new DormitoryAdminDaoImpl();

    @Override
    public List<DormitoryAdmin> list() {
        return dormitoryAdminDao.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key,String value) {

        if (value.equals("")) return this.dormitoryAdminDao.list();

        return this.dormitoryAdminDao.search(key, value);
    }

    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        Integer save = this.dormitoryAdminDao.save(dormitoryAdmin);
        if (save != 1) {
            throw new RuntimeException("宿管信息添加失败");
        }
    }

    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        Integer save = this.dormitoryAdminDao.update(dormitoryAdmin);
        if (save != 1) {
            throw new RuntimeException("宿管信息更新失败");
        }
    }

    @Override
    public void delete(Integer id) {
        Integer delete = this.dormitoryAdminDao.delete(id);
        if (delete != 1) {
            throw new RuntimeException("宿管信息更新失败");
        }
    }

    @Override
    public DormitoryAdminDto login(String username, String password) {
        //1、通过username查询数据库
        //2、查询结果为空，username错误
        //3、查询结果不为空，再判断password是否正确
        DormitoryAdmin dormitoryAdmin = this.dormitoryAdminDao.findByUsername(username);
        DormitoryAdminDto dormitoryAdminDto = new DormitoryAdminDto();
        if(dormitoryAdmin == null){
            dormitoryAdminDto.setCode(-1);
        } else {
            if(!dormitoryAdmin.getPassword().equals(password)){
                dormitoryAdminDto.setCode(-2);
            } else {
                dormitoryAdminDto.setCode(0);
                dormitoryAdminDto.setDormitoryAdmin(dormitoryAdmin);
            }
        }
        return dormitoryAdminDto;
    }
}
