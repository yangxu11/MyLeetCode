package leetcode;

/**
 * 按列翻转得到最大值等行数
 *
 * @author yx
 * @create 2019-06-02  10:57
 **/
public class Q5077 {
    int xlen;
    int ylen;
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        xlen = matrix.length;
        ylen = matrix[0].length;
        int res = 0;
        for(int i=0 ; i<xlen ; i++){
            res = Math.max(res,count(matrix,i));
        }
        return res;
    }
    public int count(int[][] matrix,int index){

        for(int i=0 ; i<ylen ; i++){
            if(matrix[index][i] != 0){
                reverse(matrix,i);
            }
        }
        int count = 0;
        for(int i=0 ; i<xlen ; i++){
            if(isSame(matrix[i])){
                ++count;
            }
        }
        return count;
    }

    private boolean isSame(int[] a) {
        int num = a[0];
        for(int i=0 ; i<a.length ; i++){
            if(a[i]!=num){
                return false;
            }
        }
        return true;
    }

    public void reverse(int[][] matrix,int index){
        for(int i=0 ; i<xlen ; i++){
            matrix[i][index] = 1-matrix[i][index];
        }
    }
}
