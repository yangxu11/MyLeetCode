package leetcode;

/**
 * 朋友圈
 *
 * @author yx
 * @create 2019-06-10  19:48
 **/
public class Q547 {
    //深度优先搜索
    public int findCircleNum(int[][] M) {
        int len = M.length;
        boolean[] known = new boolean[len];
        int res = 0;

        for(int i=0 ; i<len ; i++){
            if(!known[i]){
                dfs(M,known,i);
                ++res;
            }

        }
        return res;
    }

    public void dfs(int[][] M,boolean[] known,int index){
        known[index] = true;
        for(int i=0 ; i<M.length ; i++){
            if(M[index][i] == 1 && !known[i]){
                dfs(M,known,i);
            }
        }
    }
}
