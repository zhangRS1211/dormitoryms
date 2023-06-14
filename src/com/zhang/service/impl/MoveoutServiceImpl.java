package com.zhang.service.impl;

import com.zhang.dao.DormitoryDao;
import com.zhang.dao.MoveoutDao;
import com.zhang.dao.StudentDao;
import com.zhang.dao.impl.DormitoryDaoImpl;
import com.zhang.dao.impl.MoveoutDaoImpl;
import com.zhang.dao.impl.StudentDaoImpl;
import com.zhang.entity.Moveout;
import com.zhang.service.MoveoutService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-19  21:37
 * @Description: TODO
 * @Version: 1.0
 */
public class MoveoutServiceImpl implements MoveoutService {

    private MoveoutDao moveoutDao = new MoveoutDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private DormitoryDao dormitoryDao = new DormitoryDaoImpl();

    @Override
    public void save(Moveout moveout) {
        Integer updateStateById = this.studentDao.updateStateById(moveout.getStudentId());
        Integer addAvailable = this.dormitoryDao.addAvailable(moveout.getDormitoryId());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        moveout.setCreateDate(simpleDateFormat.format(date));
        Integer save = this.moveoutDao.save(moveout);
        if (save != 1 || updateStateById != 1 || addAvailable != 1) throw new RuntimeException("迁出学生信息保存失败");
    }

    @Override
    public List<Moveout> list() {
        return moveoutDao.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
       if(value.equals("")) return this.moveoutDao.list();
       return this.moveoutDao.search(key, value);
    }

}
