package leetcode;

/**
 * 左叶子之和
 *
 * @author yx
 * @create 2019-05-15  21:56
 **/
public class Q404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null){
            return sumOfLeftLeaves(root.right);
        }else if(root.left.right==null && root.left.left==null){
            return sumOfLeftLeaves(root.right)+ root.left.val;
        } else{
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}
