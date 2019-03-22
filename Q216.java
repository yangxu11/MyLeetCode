package leetcode;

import java.util.ArrayList;
import java.util.List;
//组合总数III
public class Q216 {
    //思路同组合总数 I II
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0,k,n,new ArrayList<>(),0);
        return res;
    }
    public void dfs(int index,int k,int n,List<Integer> list,int sum){
        if(list.size()==k && sum==n ){
            res.add(new ArrayList<>(list));
        }
        for(int i=index ; i<9 ; i++){
            list.add(i+1);
            dfs(i+1,k,n,list,sum+i+1);
            list.remove(list.size()-1);
        }
    }
}
