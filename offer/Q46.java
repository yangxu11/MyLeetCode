package leetcode.offer;

/**
 * 圆圈中的最后一个数
 *
 * @author yx
 * @create 2019-05-08  19:50
 **/
public class Q46 {
    public int LastRemaining_Solution(int n, int m) {
        if(m==0 && n==0) return -1;
        if(n==1) return 0;
        int[] visited = new int[n];
        int count = 0;
        int index = 0;
        while(count<n-1){
            for(int i=0 ; i<m ; i++){
                while(visited[index]==1){
                    ++index;
                    if(index==n){
                        index = 0;
                    }
                }
                ++index;
                if(index==n){
                    index = 0;
                }
            }
            if(index==0){
                visited[n-1] = 1;
            } else{
                visited[index-1] = 1;
            }
            ++count;
        }
        int res = 0;
        for(int i=0 ; i<n ; i++){
            if(visited[i] == 0){
                res = i;
                break;
            }
        }
        return res;
    }
}
