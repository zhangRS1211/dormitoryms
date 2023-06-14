package com.zhang.entity;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.entity
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-10  20:37
 * @Description: TODO
 * @Version: 1.0
 */
public class SystemAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;

    public SystemAdmin(Integer id, String username, String password, String name, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String telephone;
}
