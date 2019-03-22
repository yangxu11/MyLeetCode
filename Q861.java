package leetcode;
//翻转矩阵后的得分
//先行比较，如果第一位是0，则反转整行
//列比较，如果一列中0多则翻转这一列
public class Q861 {
    //75%
    public int matrixScore(int[][] A) {
        int xlen = A.length;
        int ylen = A[0].length;

        for(int[] a : A){
            if(a[0]==0) move(a);
        }

        for(int j=0 ; j<ylen ; j++){
            int count0 = 0;
            int count1 = 0;
            for(int i=0 ; i<xlen ; i++){
                if(A[i][j]==1){
                    count1++;
                } else {
                    count0++;
                }
            }
            if(count0>count1){
                for(int i=0 ; i<xlen ; i++){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int  result = 0;
        for(int i=0 ; i<xlen ; i++){
            int sum=0;
            for(int j=0 ; j<ylen ; j++){
                sum = sum*2 + A[i][j];
            }
            result += sum;
        }
        return result;
    }

    public void move(int[] a){
        for(int i=0 ; i<a.length ; i++){
            a[i]=1-a[i];
        }
    }
}
