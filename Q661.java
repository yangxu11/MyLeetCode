package leetcode;
//图片平滑器
public class Q661 {
    //24ms 88%
    //暴力解法，主要是考察对二维数组图周围元素的遍历
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for(int i=0 ; i<M.length ; i++){
            for(int j=0 ; j<M[0].length ; j++){
                result[i][j] = getScale(M,i,j);
            }
        }
        return result;

    }
    public int getScale(int[][] M,int x,int y){
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int sum=M[x][y];
        int count=1;
        for(int[] dir : dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            if(i<0 || i>=M.length || j<0 || j>=M[0].length)
                continue;
            sum += M[i][j];
            count++;
        }
        return sum/count;
    }
}
