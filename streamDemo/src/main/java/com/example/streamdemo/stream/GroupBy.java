package com.example.streamdemo.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 对List进行分类
 */
public class GroupBy {
    public static void main(String[] args) {
        //1、简单分类
        List<Dog> list = new ArrayList<>();
        Dog dog1 = new Dog("liuyuyang","dog1",3);
        Dog dog2 = new Dog("liuyuyang","dog2",2);
        Dog dog3 = new Dog("bzd","dog3",1);
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        //如果例子很多行程，先将行程通过时间排序
        list.sort(Comparator.comparing(Dog::getAge));
        System.out.println(JSON.toJSONString(list));
        Map<String, Map<Integer, String>> collect = list.stream().collect(Collectors.groupingBy(dog -> dog.getMasterName(), Collectors.toMap(Dog::getAge, Dog::getName)));
        System.out.println(JSON.toJSONString(collect));
        //将行程通过城市归类
        Map<String, List<Dog>> collect1 = list.stream().collect(Collectors.groupingBy(dog -> dog.getName() + "," + "区"));
        System.out.println(JSON.toJSONString(collect1));
        //2、分类排序
        //最后将行程通过key排序之后组装成新的行程
        collect1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(JSON.toJSONString(collect1));

    }
}

@Data
class Animal{

}

@Data
class Dog{
    public Dog(String masterName, String name, Integer age) {
        this.masterName = masterName;
        this.name = name;
        this.age = age;
    }

    private String masterName;
    private String name;
    private Integer age;
}

class Cat{
    public Cat(String masterName, String name, Integer age) {
        this.masterName = masterName;
        this.name = name;
        this.age = age;
    }

    private String masterName;
    private String name;
    private Integer age;
}

class Monkey{
    public Monkey(String masterName, String name, Integer age) {
        this.masterName = masterName;
        this.name = name;
        this.age = age;
    }

    private String masterName;
    private String name;
    private Integer age;
}
