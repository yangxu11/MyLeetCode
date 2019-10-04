package leetcode;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印FooBar
 *
 * @author yx
 * @create 2019-10-04  10:40
 **/
public class Q1115 {
    //生产者，消费者
    class FooBar {
        private int n;

        ArrayBlockingQueue<Integer> fooQueue = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Integer> barQueue = new ArrayBlockingQueue<>(1);
        public FooBar(int n) {
            this.n = n;
            try{
                barQueue.put(0);
            } catch(Exception e){
                e.printStackTrace();
            }

        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barQueue.take();
                printFoo.run();
                fooQueue.put(0);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooQueue.take();
                printBar.run();
                barQueue.put(0);
            }
        }
    }


    //lock  condition 生产者消费者
    class FooBar1 {
        private int n;

        LinkedList<Integer> queue = new LinkedList<>();
        volatile int capacity = 1;
        Lock lock = new ReentrantLock();
        Condition foo = lock.newCondition();
        Condition bar = lock.newCondition();
        public FooBar1(int n) {
            this.n = n;
            //queue.offer(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    while(queue.size() == capacity){
                        foo.await();
                    }
                    printFoo.run();
                    queue.offer(0);
                    bar.signal();
                } finally{
                    lock.unlock();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    while(queue.isEmpty()){
                        bar.await();
                    }
                    printBar.run();
                    queue.poll();
                    foo.signal();
                } finally{
                    lock.unlock();
                }

            }
        }
    }
}
