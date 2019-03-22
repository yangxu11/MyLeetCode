package leetcode;
//优美排列
public class Q526 {
    //执行用时: 117 ms, 在Beautiful Arrangement的Java提交中击败了17.88% 的用户
    //内存消耗: 32.9 MB, 在Beautiful Arrangement的Java提交中击败了0.00% 的用户

    //回溯
    int res = 0;
    public int countArrangement(int N) {
        dfs(N,1,new int[N+1]);
        return res;

    }
    public void dfs(int N,int num,int[] visited){
        if(num>N) {
            res++;
            return;
        }
        for(int i=1 ; i<=N ; i++){
            if(visited[i]==0){
                if(i%num==0 || num%i==0){
                    visited[i]=1;
                    dfs(N,num+1,visited);
                    visited[i]=0;
                }
            }
        }
    }
}
