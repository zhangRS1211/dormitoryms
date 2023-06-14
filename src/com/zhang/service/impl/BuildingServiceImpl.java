package com.zhang.service.impl;

import com.zhang.dao.BuildingDao;
import com.zhang.dao.DormitoryDao;
import com.zhang.dao.StudentDao;
import com.zhang.dao.impl.BuildingDaoImpl;
import com.zhang.dao.impl.DormitoryDaoImpl;
import com.zhang.dao.impl.StudentDaoImpl;
import com.zhang.entity.Building;
import com.zhang.entity.Dormitory;
import com.zhang.service.BuildingService;

import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-16  19:24
 * @Description: TODO
 * @Version: 1.0
 */
public class BuildingServiceImpl implements BuildingService {
    private BuildingDao buildingDao = new BuildingDaoImpl();
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Building> list() {
        return this.buildingDao.list();
    }

    @Override
    public List<Building> search(String key, String value) {

        if(value.equals("")) return this.buildingDao.list();

        return this.buildingDao.search(key,value);
    }

    @Override
    public void save(Building building) {
        Integer save = this.buildingDao.save(building);
        if (save != 1) throw new RuntimeException("添加楼宇信息失败");
    }

    @Override
    public void update(Building building) {
        Integer save = this.buildingDao.update(building);
        if (save != 1) throw new RuntimeException("更新楼宇信息失败");
    }

    @Override
    public void delete(Integer id) {
        //删除楼宇之前先把学生安排到其他宿舍

        //1.通过楼宇id把宿舍id找出来
        List<Integer> dormitoryIdList = this.dormitoryDao.findDormitoryIdByBuildingId(id);
        for(Integer dormitoryId : dormitoryIdList){
            //2.通过宿舍id把宿舍学生找出来
            List<Integer> studentIdList = this.studentDao.findStudentIdByDormitoryId(dormitoryId);
            for (Integer studentId:studentIdList) {
                Integer availableId = this.dormitoryDao.availableId();
                //3.宿舍学生被分配到空闲宿舍
                Integer updateDormitory = this.studentDao.updateDormitory(studentId, availableId);
                Integer subavailable = this.dormitoryDao.subAvailable(availableId);
                if (updateDormitory != 1 || subavailable != 1 )throw new RuntimeException("学生更换宿舍失败");
            }
        }
        //删除宿舍
        for(Integer dormitoryId : dormitoryIdList){
            Integer delete = this.dormitoryDao.deleteById(dormitoryId);
            if(delete != 1) throw new RuntimeException("宿舍删除失败");
        }
        //删除楼宇
        Integer delete = this.buildingDao.delete(id);
        if (delete != 1) throw new RuntimeException("删除楼宇失败");

    }
}
