package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删点成林
 *
 * @author yx
 * @create 2019-07-07  15:48
 **/
public class Q5119 {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null) return res;
        Set<Integer> set = new HashSet<>();
        for(int num : to_delete){
            set.add(num);
        }
        dfs(root,set,true);
        return res;
    }

    private void dfs(TreeNode root, Set<Integer> set, boolean sign){
        if(root==null) return;
        if(sign){
            res.add(root);
        }
        if(set.contains(root.val)){
            dfs(root.left,set,true);
            dfs(root.right,set,true);
            res.remove(root);
            root=null;
        } else{
            if(root.left!=null && set.contains(root.left.val)){
                dfs(root.left,set,false);
                root.left=null;
            } else{
                dfs(root.left,set,false);
            }
            if(root.right!=null && set.contains(root.right.val)){
                dfs(root.right,set,false);
                root.right=null;
            } else{
                dfs(root.right,set,false);
            }
        }
    }
}
