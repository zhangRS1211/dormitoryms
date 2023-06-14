package com.zhang.service;

import com.zhang.entity.Dormitory;

import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.service
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-14  20:08
 * @Description: TODO
 * @Version: 1.0
 */
public interface DormitoryService {
    public List<Dormitory> availableList();
    public List<Dormitory> list();
    public List<Dormitory> search(String key,String value);
    public void save(Dormitory dormitory);
    public void update(Dormitory dormitory);
    public void delete(Integer id);
    public List<Dormitory> findByBuildingId(Integer buildingId);
}
