package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 地图分析
 *
 * @author yx
 * @create 2019-08-18  11:16
 **/
public class Q5053 {


    //广度优先搜索经典题，广度优先搜索使用queue队列

    int len;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    //广度优先搜索，一层一层加入队列中，使用level存储搜索的深度，使用visited记录已经遍历过的点
    public int maxDistance1(int[][] grid) {
        len = grid.length;
        if(len==1) return -1;
        boolean[][] visited = new boolean[len][len];

        LinkedList<int[]> queue = new LinkedList<>();

        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                if(grid[i][j]==1){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int level = -1;
        while(!queue.isEmpty()){
            ++level;
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                int[] a = queue.poll();
                for(int[] dir : dirs){
                    int x = a[0] + dir[0];
                    int y = a[1] + dir[1];
                    if(x>=0 && x<len && y>=0 && y<len && !visited[x][y]){
                        queue.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return level==0 ? -1 : level;
    }

    //广度优先搜索，使用dp数组存储当前最小值
    public int maxDistance2(int[][] grid) {
        len = grid.length;
        if(len==1) return -1;
         int[][] dp = new int[len][len];

         for(int i=0 ; i<len ; i++){
             Arrays.fill(dp[i],205);
         }
        boolean[][] visited = new boolean[len][len];

        LinkedList<int[]> queue = new LinkedList<>();

        for(int i=0 ; i<len ; i++){
            for(int j=0 ; j<len ; j++){
                if(grid[i][j]==1){
                    dp[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }


         while(!queue.isEmpty()){
             int[] a = queue.poll();

             for(int[] dir : dirs){

                 int x = a[0] + dir[0];
                 int y = a[1] + dir[1];

                 if(x>=0 && x<len && y>=0 && y<len && dp[x][y]>dp[a[0]][a[1]]+1){
                     dp[x][y] = dp[a[0]][a[1]]+1;
                     queue.offer(new int[]{x,y});
                 }

             }
         }
         int res = 0;
         for(int i=0 ; i<len ; i++){
             for(int j=0 ; j<len ; j++){
                 if(grid[i][j]==0){
                     res = Math.max(res,dp[i][j]);
                 }
             }
         }

        return res==205||res==0 ? -1 : res;
    }
}
