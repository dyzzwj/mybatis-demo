package com.dyzwj.mybatis.bean;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年08月17日 19:14:00
 */
public class User {

    private Integer id;
    private String name;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
