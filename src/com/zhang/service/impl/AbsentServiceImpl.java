package com.zhang.service.impl;

import com.zhang.dao.AbsentDao;
import com.zhang.dao.impl.AbsentDaoImpl;
import com.zhang.entity.Absent;
import com.zhang.service.AbsentService;

import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-20  19:09
 * @Description: TODO
 * @Version: 1.0
 */
public class AbsentServiceImpl implements AbsentService {
    private AbsentDao absentDao = new AbsentDaoImpl();
    @Override
    public void save(Absent absent) {
        Integer save = this.absentDao.save(absent);
        if(save != 1) throw new RuntimeException("添加缺勤记录失败");
    }

    @Override
    public List<Absent> list() {
        return this.absentDao.list();
    }

    @Override
    public List<Absent> search(String key, String value) {
        if(value.equals("")) return this.absentDao.list();
        return this.absentDao.search(key, value);
    }
}
