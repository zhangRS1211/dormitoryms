package com.zhang.dao.impl;

import com.zhang.dao.DormitoryAdminDao;
import com.zhang.entity.DormitoryAdmin;
import com.zhang.entity.SystemAdmin;
import com.zhang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.dao.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-11  22:22
 * @Description: TODO
 * @Version: 1.0
 */

public class DormitoryAdminDaoImpl implements DormitoryAdminDao {
    @Override
    public List<DormitoryAdmin> list() {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from dormitory_admin";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DormitoryAdmin> list = new ArrayList<>();
        try {
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String telephone = resultSet.getString(6);

                list.add(new DormitoryAdmin(id,username,password,name,gender,telephone));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,resultSet);
        }

        return list;
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from dormitory_admin where "+key+" like '%"+value+"%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DormitoryAdmin> list = new ArrayList<>();
        try {
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String telephone = resultSet.getString(6);

                list.add(new DormitoryAdmin(id,username,password,name,gender,telephone));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,resultSet);
        }

        return list;
    }

    @Override
    public Integer save(DormitoryAdmin dormitoryAdmin) {
        Connection con = JDBCUtil.getConnection();
        String sql = "insert into dormitory_admin(username,password,name,gender,telephone) values (?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,dormitoryAdmin.getUsername());
            statement.setString(2,dormitoryAdmin.getTelephone());
            statement.setString(3,dormitoryAdmin.getName());
            statement.setString(4,dormitoryAdmin.getGender());
            statement.setString(5,dormitoryAdmin.getTelephone());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,null);
        }
        return result;
    }

    @Override
    public Integer update(DormitoryAdmin dormitoryAdmin) {
        Connection con = JDBCUtil.getConnection();
        String sql = "update dormitory_admin set username=?,password=?,name=?,gender=?,telephone=? where id= ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,dormitoryAdmin.getUsername());
            statement.setString(2,dormitoryAdmin.getTelephone());
            statement.setString(3,dormitoryAdmin.getName());
            statement.setString(4,dormitoryAdmin.getGender());
            statement.setString(5,dormitoryAdmin.getTelephone());
            statement.setInt(6,dormitoryAdmin.getId());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,null);
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Connection con = JDBCUtil.getConnection();
        String sql = "delete from dormitory_admin where id= "+id;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = con.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,null);
        }
        return result;
    }

    @Override
    public DormitoryAdmin findByUsername(String username) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from dormitory_admin where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DormitoryAdmin dormitoryAdmin = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                dormitoryAdmin = new DormitoryAdmin(id,username, password, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return dormitoryAdmin;
    }
}

