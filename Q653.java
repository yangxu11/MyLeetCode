package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两数之和IV-输入BST树
 *
 * @author yx
 * @create 2019-07-04  10:54
 **/
public class Q653 {
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
