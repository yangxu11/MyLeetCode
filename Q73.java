package leetcode;
//矩阵置零
public class Q73 {
    //空间复杂度o(m*n) 88%
    //使用数组记录矩阵中0的横纵坐标
    //使用数组比list,set效率高的多
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;

        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]==0) {
                    row[i]=1;
                    column[j]=1;
                }
            }
        }

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(row[i]==1||column[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    //空间复杂度 O(1) 55%
    //使用第一行和第一列 存储0的坐标，但要主要第一行和第一列本身是否包含0
    public void setZeroes2(int[][] matrix) {
        if(matrix.length==0) return;

        int row = 0;
        int column = 0;
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                    if(i==0) row=1;
                    if(j==0) column=1;
                }
            }
        }

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length ; j++){
                if(i!=0 && j!=0 && (matrix[i][0]==0||matrix[0][j]==0)){
                    matrix[i][j]=0;
                }
            }
        }
        if(row == 1){
            for(int i=0 ; i<matrix[0].length ; i++){
                matrix[0][i]=0;
            }
        }
        if(column == 1){
            for(int i=0 ; i<matrix.length ; i++){
                matrix[i][0]=0;
            }
        }
    }
}
