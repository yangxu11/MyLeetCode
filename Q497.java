package leetcode;

import java.util.Random;

/**
 * 非重叠矩阵中的随机点
 *
 * @author yx
 * @create 2019-06-01  18:16
 **/
public class Q497 {
    //注意取的是整数点，所以计算面积时 横纵坐标都要+1
    class Solution {
        int sum;
        int[] agg;
        Random rand;
        int[][] rects;
        public Solution(int[][] rects) {
            this.rects = rects;
            rand = new Random();
            agg = new int[rects.length];
            int index = 0;
            for(int[] rect : rects){
                sum += (rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
                agg[index++] = sum;
            }
        }

        public int[] pick() {
            int target = rand.nextInt(sum) +1;
            int index = 0;
            for(int i=0 ; i<agg.length ; i++){
                if(target<=agg[i]){
                    index = i;
                    break;
                }
            }
            int[] rect = rects[index];
            int xlen = rect[2]-rect[0]+1;
            int ylen = rect[3]-rect[1]+1;
            int x = rand.nextInt(xlen)+rect[0];
            int y = rand.nextInt(ylen)+rect[1];
            return new int[]{x,y};
        }
    }
}
