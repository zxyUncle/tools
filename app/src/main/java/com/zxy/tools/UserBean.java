package com.zxy.tools;

public class UserBean {
    private String name="张三";
    private float prices = 1.2f;
    private String password="123465";

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", prices=" + prices +
                ", password='" + password + '\'' +
                '}';
    }
}
