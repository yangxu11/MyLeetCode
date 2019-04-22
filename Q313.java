package leetcode;

import java.util.PriorityQueue;

public class Q313 {

    public static void main(String[] args) {
        int[] a = {2,7,13,19};
        Q313 q = new Q313();
        System.out.println( q.nthSuperUglyNumber(12,a));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] cur = new int[primes.length];
        for(int i=0 ; i<primes.length ; i++){
            pq.add(primes[i]);
            cur[i] = primes[i];
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indexs = new int[primes.length];
        int count =1;
        while(count<n){
            int min = pq.peek();
            ugly[count++] = min;
            for(int i=0 ; i<cur.length ; i++){
                if(cur[i]==min){
                    int index = indexs[i];
                    index++;
                    pq.add(ugly[index]*primes[i]);
                    cur[i] = ugly[index]*primes[i];
                    indexs[i] += 1;
                    pq.poll();
                }
            }

        }
        return ugly[n-1];
    }
}



