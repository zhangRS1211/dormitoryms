package com.zhang.dao.impl;

import com.zhang.dao.SystemAdminDao;
import com.zhang.entity.SystemAdmin;
import com.zhang.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.dao.impl
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  21:51
 * @Description: TODO
 * @Version: 1.0
 */
public class SystemAdminDaoImpl implements SystemAdminDao {
    @Override
    public SystemAdmin findByUsername(String username) {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from system_admin where username = '"+username+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String telephone = resultSet.getString(5);

                return new SystemAdmin(id,username,password,name,telephone);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.release(con,statement,resultSet);
        }

        return null;
    }
}







