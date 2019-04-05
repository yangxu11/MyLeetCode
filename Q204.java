package leetcode;

import java.util.Arrays;

//计数质数，筛选法
public class Q204 {

//    public int countPrimes(int n) {  超时
//        int count = 0;
//        for (int i = 1; i < n; i++) {
//            if (isPrime(i)) count++;
//        }
//        return count;
//    }
//
//    private boolean isPrime(int num) {
//        if (num <= 1) return false;
//        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
//        // to avoid repeatedly calling an expensive function sqrt().
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

    public int countPrimes(int n) {
        int count =0 ;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        for(int i=2 ; i<n ; i++) {
            if(isPrime[i]) {
                for(int j=i+i ; j<n ; j+=i) {
                    isPrime[j] = false;
                }
                count++;
            }
        }
        return count;
    }

}
