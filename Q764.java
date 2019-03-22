package leetcode;

import java.util.Arrays;

//最大加号标志
public class Q764 {
    //执行用时: 166 ms, 在Largest Plus Sign的Java提交中击败了65.00% 的用户
    //内存消耗: 61.6 MB, 在Largest Plus Sign的Java提交中击败了33.33% 的用户

    //求每个点上，下，左，右能到达的最小值
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int[] m:grid) {
            Arrays.fill(m, N);//初始化为较大值
        }
        for(int[] m:mines) {
            grid[m[0]][m[1]] = 0;
        }
        for(int i = 0; i < N; i++) {
            int l = 0, r = 0, u = 0, d = 0;
            for(int j = 0, k = N - 1; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));//由左至右
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));//由右至左
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));//由上至下
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));//由下至上
            }
        }
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
    //执行用时: 2191 ms, 在Largest Plus Sign的Java提交中击败了0.00% 的用户
    //内存消耗: 53.8 MB, 在Largest Plus Sign的Java提交中击败了33.33% 的用户

    //暴力法
    public int orderOfLargestPlusSign2(int N, int[][] mines) {
        int max = 0;
        int[][] nums = new int[N][N];
        for(int[] mine : mines){
            nums[mine[0]][mine[1]] = 1;
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                int min = N;
                if(nums[i][j] == 1) continue;
                int flag = 0;
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    int m = 1;
                    while(x>=0 && x<N && y>=0 && y<N && nums[x][y]!=1){
                        x+=dir[0];
                        y+= dir[1];
                        m++;
                    }
                    min = Math.min(min,m);
                }
                max = Math.max(min,max);
            }
        }
        return max;
    }
}
