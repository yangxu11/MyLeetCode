package leetcode;

/**
 * 搜索矩阵II
 *
 * @author yx
 * @create 2019-04-11  17:25
 **/
public class Q240 {
    //以第一行末尾为起始标记，如果>target 说明列值偏大j--（行已经为最小），如果<target 说明 行偏小（列已经为最大）i++
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i=0;
        int j= matrix[0].length-1;

        while(i<matrix.length && j>=0){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j]<target){
                i++;
            } else{
                j--;
            }
        }
        return false;
    }
}
