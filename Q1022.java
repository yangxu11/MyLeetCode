package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q1022 {
    public int smallestRepunitDivByK(int K) {
        if(K==1) return 1;
        if(K%2==0) return -1;

        /**
         *	存相应的余数，然后判断余数是不是有重复
         */

        //首先开始的数值是1,11,111,1111,11111,111111


        Set<Integer> set = new HashSet<Integer>();
        int start =1;
        int number  =1;

        while(true){
            int yushu = start%K;
            if(yushu ==0) return number;
            if(!set.add(yushu)){
                return -1;
            }
            //然后通过余数构建下一个数
            while(yushu < K){
                yushu = 10*yushu+1;
                ++number;
            }
            start = yushu;
        }
    }
}
