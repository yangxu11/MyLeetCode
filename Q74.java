package leetcode;
//搜索二维矩阵
public class Q74 {
    //85%  二分查找，先找到相应行，再从行中查找
    //注意，二分查找除非只有一个，不然start!=end,需要在mid==start时做出判断
    //在查找行号时，注意最后一行，
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        int start=0;
        int end = matrix.length-1;

        int index=0;
        //找到所在行，二分查找时注意不是matrix[mid][0] < target就可以将其舍弃的
        while(start<end){
            if(target>=matrix[end][0]){//注意筛选最后一行
                index=end;
                break;
            }
            int mid = (start+end)/2;
            if(mid==start){//在mid==start时判断并退出循环
                index=start;
                break;
            }
            if(matrix[mid][0]>target){
                end = mid;
            } else if(matrix[mid][0]<target){
                start = mid;
            }  else{
                return true;
            }
        }
        int[] row = matrix[index];
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
