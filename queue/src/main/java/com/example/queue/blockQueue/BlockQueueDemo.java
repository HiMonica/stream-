package com.example.queue.blockQueue;

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockQueueDemo {

    //默认为10
    private int num = 10;

    //开关
    private volatile Boolean isRunning = true;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private ArrayBlockingQueue queue = new ArrayBlockingQueue(num);

    {
        init();
    }

    public void init(){
        if (isRunning){
            executor.execute(() -> {
                while (isRunning){
                    try {
                        User user = (User) queue.take();
                        sendPoint(user);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void sendPoint(User user) {
        System.out.println("发送积分给指定用户：" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BlockQueueDemo(int num) {
        this.num = num;
    }

    public BlockQueueDemo(){
        this(10);
    }

    public boolean register(){
        while (isRunning){
            User user = new User();
            user.setName("liuyuyang");
            addUser(user);
            queue.add(user);
        }
        return true;
    }

    private void addUser(User user){
        System.out.println("添加用户：" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //入口
        new BlockQueueDemo().register();
    }


}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
