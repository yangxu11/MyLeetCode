package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * 打印零和奇偶数
 *
 * @author yx
 * @create 2019-10-04  13:09
 **/
public class Q1116 {
    class ZeroEvenOdd {
        private int n;

        CountDownLatch c1= new CountDownLatch(0);
        CountDownLatch c2= new CountDownLatch(1);
        CountDownLatch c3= new CountDownLatch(1);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for(int i=0 ; i<n ; i++){
                c1.await();
                printNumber.accept(0);
                c1 = new CountDownLatch(1);
                if(i%2==0){
                    c3.countDown();
                } else{
                    c2.countDown();
                }
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {

            for(int i=2 ; i<=n ; i+=2){
                c2.await();
                printNumber.accept(i);
                c2 = new CountDownLatch(1);
                c1.countDown();
            }


        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

            for(int i=1 ; i<=n ; i+=2){
                c3.await();
                printNumber.accept(i);
                c3 = new CountDownLatch(1);
                c1.countDown();

            }


        }

    }
}
