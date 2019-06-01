package leetcode;

/**
 * 对角线遍历
 *
 * @author yx
 * @create 2019-06-01  18:08
 **/
public class Q498 {
    //以3*3为例，遍历的顺序为
    // [0,0]                 0
    //[0,1] [1,0]            1
    //[2,0] [1,1] [0,2]      2
    //[1,2] [2,1]            3
    //[2,2]                  4
    //每条对角线都有相同的和，只需要找到起点，横纵坐标+-1就可以对角线遍历
    //重点是起点的寻找，规律是，如果横纵坐标都没到极限，则先横+1，下一个起点纵+1，如此轮流
    //如果到达极限，则换另一个坐标+1
    public int[] findDiagonalOrder(int[][] matrix) {
        int xlen = matrix.length;
        if(xlen==0) return new int[0];
        int ylen = matrix[0].length;
        if(ylen == 0) return new int[0];

        int[] res = new int[xlen*ylen];
        int total = xlen-1 + ylen-1;
        int x = 0;
        int y = 0;
        int sign = 0;
        res[0] = matrix[x][y];
        int index = 1;
        for(int i=1 ; i<=total ; i++){
            if(sign == 0){
                if(y==ylen-1){//y到达极限
                    x++;
                } else{
                    y++;
                }
                while(x>=0&&x<xlen && y>=0 && y<ylen){//横纵+-1遍历对角线
                    res[index++] = matrix[x][y];
                    x++;
                    y--;
                }
                x--;
                y++;
                sign = 1;
            } else{
                if(x==xlen-1){
                    y++;
                }else{
                    x++;
                }
                while(x>=0&&x<xlen && y>=0 && y<ylen){
                    res[index++] = matrix[x][y];
                    x--;
                    y++;
                }
                x++;
                y--;
                sign = 0;
            }
        }
        return res;
    }
}
