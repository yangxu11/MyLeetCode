package leetcode;

import java.util.*;
/*
 * @Author YX
 * @Description 二叉树中的众数
 * @Date 10:05 2019/6/2
 * @Param
 * @return
 **/

//中序遍历中夹杂判断
public class Q501 {

    int max = 1;
    int cur = 1;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return new int[0];
        dfs(root,res);
        int[] ans = new int[res.size()];
        for(int i=0 ; i<res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
    private void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        if(pre!=null){
            if(pre.val==root.val){
                ++cur;
            } else{
                cur=1;
            }
        }
        if(cur == max){
            list.add(root.val);
        }
        if(cur > max){
            list.clear();
            list.add(root.val);
            max = cur;
        }
        pre = root;
        dfs(root.right,list);
    }

}
