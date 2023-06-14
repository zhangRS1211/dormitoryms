package com.zhang.entity;

/**
 * @BelongsProject: dormitoryms
 * @BelongsPackage: com.zhang.entity
 * @Author: 敲码的猴子
 * @CreateTime: 2022-10-11  22:12
 * @Description: TODO
 * @Version: 1.0
 */
public class DormitoryAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String telephone;

    public DormitoryAdmin(Integer id, String username, String password, String name, String gender, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
    }

    public DormitoryAdmin(String username, String password, String name, String gender, String telephone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
    }

    public DormitoryAdmin(Integer id, String username, String password, String name) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
