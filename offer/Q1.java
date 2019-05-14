package leetcode.offer;

/**
 * 二维数组中的查找
 *
 *题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author yx
 * @create 2019-05-02  11:14
 **/
public class Q1 {
    public boolean Find(int target, int [][] array) {
        int xlen = array.length;
        if(xlen==0) return false;
        int ylen = array[0].length;
        if(ylen ==0) return false;

        int i=0;
        int j=ylen-1;

        while(i<xlen && j>=0){
            if(array[i][j]>target){
                --j;
            } else if(array[i][j]<target){
                ++i;
            } else{
                return true;
            }
        }
        return false;
    }
}