package com.example.springstudy.createBean;

import lombok.Data;

/**
 * @author julu
 * @date 2022/11/20 11:26
 */
@Data
public class User {

    private Long id;

    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser(){
        return new User();
    }
}
