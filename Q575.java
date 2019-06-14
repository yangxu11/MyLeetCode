package leetcode;

import java.util.Arrays;

/**
 * 分糖果
 *
 * @author yx
 * @create 2019-06-14  20:47
 **/
public class Q575 {
    public int distributeCandies(int[] candies) {
        int num = candies.length/2;

        Arrays.sort(candies);

        int pre = candies[0];
        int count=1;
        for(int i=1 ; i<candies.length ; i++){
            if(candies[i] != pre){
                count++;
                pre = candies[i];
            }
        }

        return Math.min(count,num);
    }
}
