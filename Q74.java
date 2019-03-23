package leetcode;
//搜索二维矩阵
public class Q74 {
    //最优解，行号和列号同时寻找，就是简单二分法
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(matrix[mid/n][mid%n] == target)
                return true;
            if(target < matrix[mid/n][mid%n])
                end = mid - 1;
            if(target > matrix[mid/n][mid%n])
                start = mid + 1;
        }
        return false;
    }


    //85%  二分查找，先找到相应行，再从行中查找
    //注意，二分查找除非只有一个，不然start!=end,需要在mid==start时做出判断
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int xlen = matrix.length;
        int ylen = matrix[0].length;

        int start = 0;
        int end = xlen-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(matrix[mid][0] > target){
                end = mid -1;
            } else if(matrix[mid][0] < target){
                //判断target是否在这一行，是break，不是start=mid+1继续
                if(matrix[mid][ylen-1] >=target){
                    start = mid;
                    break;
                } else {
                    start = mid+1;
                }
            } else {
                return true;
            }
        }
        int[] row = matrix[start];
        start = 0;
        end = row.length-1;

        //二分查找行，找出元素
        while(start<=end){
            int mid = (start+end)/2;
            if(row[mid]>target){
                end = mid-1;
            } else if(row[mid]<target){
                start = mid+1;
            } else{
                return true;
            }
        }

        return false;

    }
}
