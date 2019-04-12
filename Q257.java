package leetcode;

import java.util.ArrayList;
import java.util.List;
//二叉树的所有路径
public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        getPaths(root,"",result);
        return result;
    }

    public void getPaths(TreeNode root,String s,List<String> list) {
        if(root==null) return;
        if(s.length()==0) {
            s = String.valueOf(root.val);
        } else {
            s += "->" + root.val;
        }
        if(root.right==null && root.left==null) {
            list.add(s);
        }

        getPaths(root.left,s,list);
        getPaths(root.right,s,list);
    }
}
