package leetcode;
//旋转矩阵II
public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int starti = 0,
                startj = 0,
                endi = n-1,
                endj = n-1;
        int count = 0;
        while((starti <= endi) && (startj <= endj)) {
            for(int j=startj ; j<=endj ; j++) {
                res[starti][j] = ++count;
            }
            starti++;
            if((starti > endi) || (startj > endj)) break;
            for(int i=starti ; i<=endi ; i++) {
                res[i][endj] = ++count;
            }
            endj--;
            if((starti > endi) || (startj > endj)) break;
            for(int j=endj ; j>=startj ; j--) {
                res[endi][j] = ++count;
            }
            endi--;
            if((starti > endi) || (startj > endj)) break;
            for(int i=endi ; i>=starti ; i--) {
                res[i][startj] = ++count;
            }
            startj++;
        }

        return res;
    }
}
