package leetcode.offer;

import java.util.ArrayList;

/**
 * 顺时针打印数组
 *
 * @author yx
 * @create 2019-05-04  10:39
 **/
public class Q19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int xlen = matrix.length;
        if(xlen == 0) return res;
        int ylen = matrix[0].length;
        if(ylen == 0) return res;
        int xstart=0,ystart=0,xend=xlen-1,yend=ylen-1;

        while(xstart<=xend && ystart<=yend){
            for(int i=ystart ; i<=yend ; i++){
                res.add(matrix[xstart][i]);
            }
            ++xstart;
            if(xstart>xend || ystart>yend) break;

            for(int i=xstart ; i<=xend ; i++){
                res.add(matrix[i][yend]);
            }
            --yend;
            if(xstart>xend || ystart>yend) break;

            for(int i=yend ; i>=ystart ; i--){
                res.add(matrix[xend][i]);
            }
            --xend;
            if(xstart>xend || ystart>yend) break;

            for(int i=xend ; i>=xstart ; i--){
                res.add(matrix[i][ystart]);
            }
            ++ystart;
            if(xstart>xend || ystart>yend) break;
        }
        return res;

    }
}
