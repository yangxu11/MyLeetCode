package leetcode;
//不同的路径
public class Q62 {
    //1ms 67%
    //使用一个矩阵来记录每个点的所有不同路径，先将边缘的点（最上面和最左面）置为1
    // 当前点的路径数 = 上面点的路径数 + 左边点的路径数
    // 如此一直累积，得到结果
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[n][m];
        paths[0][0]=1;
        for(int i=1 ; i<m ; i++){
            paths[0][i]=1;
        }
        for(int i=1 ; i<n ; i++){
            paths[i][0]=1;
        }

        for(int i=1 ; i<n ; i++){
            for(int j=1 ; j<m ; j++){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[n-1][m-1];
    }
}
