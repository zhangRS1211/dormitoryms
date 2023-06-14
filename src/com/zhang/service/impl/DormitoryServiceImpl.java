package com.zhang.service.impl;

import com.zhang.dao.DormitoryDao;
import com.zhang.dao.StudentDao;
import com.zhang.dao.impl.DormitoryDaoImpl;
import com.zhang.dao.impl.StudentDaoImpl;
import com.zhang.entity.Dormitory;
import com.zhang.service.DormitoryService;

import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-14  20:09
 * @Description: TODO
 * @Version: 1.0
 */
public class DormitoryServiceImpl implements DormitoryService {

    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Dormitory> availableList() {
        return this.dormitoryDao.availableList();
    }

    @Override
    public List<Dormitory> list() {
        return this.dormitoryDao.list();
    }

    @Override
    public List<Dormitory> search(String key,String value) {
         if (value.equals("")) return this.dormitoryDao.list();
         return this.dormitoryDao.search(key,value);
    }

    @Override
    public void save(Dormitory dormitory) {
        Integer save = this.dormitoryDao.save(dormitory);
        if (save != 1) throw new RuntimeException("添加宿舍信息失败");

    }

    @Override
    public void update(Dormitory dormitory) {
        Integer update = this.dormitoryDao.update(dormitory);
        if (update != 1) throw new RuntimeException("更新宿舍信息失败");
    }

    @Override
    public void delete(Integer id) {
        List<Integer> studentIdList = this.studentDao.findStudentIdByDormitoryId(id);
        for (Integer studentId : studentIdList) {
            Integer availableId = this.dormitoryDao.availableId();
            Integer updateDorimtory = this.studentDao.updateDormitory(studentId, availableId);
            Integer subAvailable = this.dormitoryDao.subAvailable(availableId);
            if(updateDorimtory != 1 || subAvailable != 1) throw new RuntimeException("学生更换宿舍失败");
        }
        Integer delete = this.dormitoryDao.deleteById(id);
        if(delete != 1) throw new RuntimeException("删除宿舍信息失败");
    }

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryDao.findByBuildingId(buildingId);
    }
}
