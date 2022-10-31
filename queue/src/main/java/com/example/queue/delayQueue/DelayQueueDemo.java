package com.example.queue.delayQueue;

import java.util.concurrent.*;

public class DelayQueueDemo {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private Boolean isRunning = true;

    private DelayQueue queue = new DelayQueue();

    {
        init();
    }

    private void init() {
        executor.execute(() -> {
            while (isRunning){
                try {
                    User user = (User) queue.take();
                    send(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void send(User user) {
        System.out.println("send" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DelayQueueDemo().register();
    }

    private boolean register() {
        while (isRunning){
            User user = new User();
            user.setName("liuyuyang");
            queue.offer(user,2000, TimeUnit.SECONDS);
        }
        return true;
    }


}

class User implements Delayed {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
