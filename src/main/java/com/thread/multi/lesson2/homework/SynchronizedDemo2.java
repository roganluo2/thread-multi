package com.thread.multi.lesson2.homework;

import java.io.IOException;

/**
 * Created by rogan on 2019/5/28.
 */
public class SynchronizedDemo2 {

    static Integer count=0;
    public static void incr(){
        synchronized (count) {//这里是对count 加锁
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++; //这里同步代码块中对加锁的对象值进行了修改，出现changelock导致锁被释放，最终结果不能是1000
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->SynchronizedDemo2.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:"+count);
    }

    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;

        static final int CANCELLED =  1;
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;


        volatile int waitStatus;

        volatile Node prev;

        volatile Node next;

        volatile Thread thread;
        //存储在condition队列中的后端节点
        Node nextWaiter;
        //是否共享锁
        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }

        Node() {
        }
        //将线程构造成node添加多队列
        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }
        //会在condition队列中使用
        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

}
