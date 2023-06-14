package com.zhang.service;

import com.zhang.dto.DormitoryAdminDto;
import com.zhang.entity.DormitoryAdmin;

import java.util.List;

public interface DormitoryAdminService {
    //method为list的时候
    public List<DormitoryAdmin> list();

    //method为search的时候
    public List<DormitoryAdmin> search(String key,String value);

    public void save(DormitoryAdmin dormitoryAdmin);

    public void update(DormitoryAdmin dormitoryAdmin);

    public void delete(Integer id);

    public DormitoryAdminDto login(String username,String password);
}
