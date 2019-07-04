package leetcode;

import java.util.*;

//寻找重复的子树
public class Q652 {
    List<TreeNode> res = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root==null) return res;
        getPath(root);
        return res;
    }

    public String getPath(TreeNode root){
        if(root==null) return "#";

        String left = getPath(root.left);
        String right = getPath(root.right);
        String path = root.val + left + right;
        map.put(path,map.getOrDefault(path,0)+1);
        if(map.get(path)==2) res.add(root);
        return path;
    }

}
