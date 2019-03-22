package leetcode;

import java.util.ArrayList;
import java.util.List;
//螺旋矩阵
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int starti = 0,
        startj = 0,
        endi = matrix.length-1,
        endj = matrix[0].length-1;

        while((starti <= endi) && (startj <= endj)) {
            for(int j=startj ; j<=endj ; j++) {
                list.add(matrix[starti][j]);
            }
            starti++;
            if((starti > endi) || (startj > endj)) break;
            for(int i=starti ; i<=endi ; i++) {
                list.add(matrix[i][endj]);
            }
            endj--;
            if((starti > endi) || (startj > endj)) break;
            for(int j=endj ; j>=startj ; j--) {
                list.add(matrix[endi][j]);
            }
            endi--;
            if((starti > endi) || (startj > endj)) break;
            for(int i=endi ; i>=starti ; i--) {
                list.add(matrix[i][startj]);
            }
            startj++;
        }

        return list;
    }
}
