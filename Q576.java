package leetcode;

public class Q576 {
    //执行用时: 38 ms, 在Out of Boundary Paths的Java提交中击败了29.11% 的用户
    //内存消耗: 28.2 MB, 在Out of Boundary Paths的Java提交中击败了33.33% 的用户

    //从边界向内部记录
    //使用数组dp[][]来储存n步后，点（i,j）超出边界的可能数
    public int findPaths1(int m, int n, int N, int i, int j) {
        if(N <= 0) return 0;
        int mod = 1000000007;
        int ret = 0;
        int[][] dp = new int[m][n]; // 保存第k步的结果
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int k = 1; k <= N; ++k) {
            int[][] temp = new int[m][n]; // 保存第k-1步的结果
            for(int x = 0; x < m; ++x) {
                for(int y = 0; y < n; ++y) {
                    for(int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                            temp[x][y] += 1;
                        else
                            temp[x][y] = (dp[nx][ny] + temp[x][y]) % mod;
                    }
                }
            }
            dp = temp;
        }

        return dp[i][j];
    }

    //执行用时: 41 ms, 在Out of Boundary Paths的Java提交中击败了13.92% 的用户
    //内存消耗: 29.1 MB, 在Out of Boundary Paths的Java提交中击败了11.11% 的用户

    //从i，j起点出发到边界
    //先计算网格中每个点一步越界的可能数，记录第n步每个点上到达的可能数，总数 += 边界点上的可能数 * 一步出界的可能数
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] grid = new int[m][n];
        for(int x=0 ; x<m ; x++){
            for(int y=0 ; y<n ; y++){
                grid[x][y] = count(m,n,x,y);
            }
        }
        int result = 0;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int mod = 1000000007;
        while(N>0){
            int[][] temp = new int[m][n];

            for(int x=0 ; x<m ; x++){
                for(int y=0 ; y<n ; y++){
                    result = (result+dp[x][y] * grid[x][y]%mod )%mod;
                    if(x-1>=0){
                        temp[x-1][y]= (temp[x-1][y] + dp[x][y])%mod;
                    }
                    if(x+1<m){
                        temp[x+1][y]= (temp[x+1][y]  + dp[x][y])%mod;
                    }
                    if(y-1>=0){
                        temp[x][y-1]= (temp[x][y-1] + dp[x][y])%mod;
                    }
                    if(y+1<n){
                        temp[x][y+1]= (temp[x][y+1] + dp[x][y])%mod;
                    }
                }

            }
            dp = temp;
            N--;

        }
        return result;
    }
    public int count(int m,int n,int i,int j){
        int count=0;
        if(i==0) count++;
        if(i==m-1) count++;
        if(j==0) count++;
        if(j==n-1) count++;
        return count;
    }

}
