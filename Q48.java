package leetcode;
//旋转图像
public class Q48 {

    //四条边对应元素顺时针换位，然后进入下一层继续
    public void rotate(int[][] matrix) {
        int L = matrix.length - 1;
        for(int i=0 ; i<matrix.length/2 ; i++) {
            int cir = L - i;
            for(int j = i ; j<cir ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[L-j][i];
                matrix[L-j][i] = matrix[L-i][L-j];
                matrix[L-i][L-j] = matrix[j][L-i];
                matrix[j][L-i] = temp;
            }
        }
    }
}
