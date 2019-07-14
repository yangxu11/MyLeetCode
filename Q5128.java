package leetcode;

/**
 * 最深叶子节点的最近公共祖先
 *
 * @author yx
 * @create 2019-07-14  12:08
 **/
public class Q5128 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return root;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left>right){
            return lcaDeepestLeaves(root.left);
        } else if(left<right){
            return lcaDeepestLeaves(root.right);
        } else{
            return root;
        }
    }

    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
