package com.zhang.service.impl;

import com.zhang.dao.DormitoryDao;
import com.zhang.dao.StudentDao;
import com.zhang.dao.impl.DormitoryDaoImpl;
import com.zhang.dao.impl.StudentDaoImpl;
import com.zhang.entity.Student;
import com.zhang.service.StudentService;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-13  20:04
 * @Description: TODO
 * @Version: 1.0
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();


    @Override
    public List<Student> list() {
        return this.studentDao.list();
    }

    @Override
    public List<Student> search(String key,String value) {
        if(value.equals("")) return this.studentDao.list();
        return this.studentDao.search(key,value);
    }

    @Override
    public void save(Student student) {
        student.setState("入住");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(simpleDateFormat.format(date));
        Integer save = this.studentDao.save(student);
        Integer sub = this.dormitoryDao.subAvailable(student.getDormitoryId());
        if (save != 1 || sub != 1) throw new RuntimeException("添加学生信息失败");
    }

    @Override
    public void update(Student student,Integer oldDormitoryId) {
        Integer update = this.studentDao.update(student);
        //原宿舍available+1，新宿舍available-1
        Integer dormitory1 = this.dormitoryDao.addAvailable(oldDormitoryId);
        Integer dormitory2 = this.dormitoryDao.subAvailable(student.getDormitoryId());
        if (update != 1 || dormitory1!=1 || dormitory2!=1) throw new RuntimeException("更新学生信息失败");
    }

    @Override
    public void delete(Integer id, Integer dormitoryId) {
        Integer delete = this.studentDao.delete(id);
        Integer available = this.dormitoryDao.addAvailable(dormitoryId);
        if (delete != 1 || available != 1) throw new RuntimeException("删除学生信息失败");
    }

    @Override
    public List<Student> moveoutList() {
        return this.studentDao.moveoutList();
    }

    @Override
    public List<Student> SearchForMoveout(String key, String value) {
        if(value.equals("")) return this.studentDao.moveoutList();
        return this.studentDao.SearchForMoveout(key,value);
    }

    @Override
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return this.studentDao.findByDormitoryId(dormitoryId);
    }

}
