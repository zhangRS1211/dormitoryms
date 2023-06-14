package com.zhang.service;

import com.zhang.entity.Building;

import java.util.List;

public interface BuildingService {
    public List<Building> list();
    public List<Building> search(String key,String value);
    public void save(Building building);
    public void update(Building building);
    public void delete(Integer id);
}
