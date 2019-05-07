package leetcode.offer;

/**
 * 平衡二叉树
 *
 * @author yx
 * @create 2019-05-07  19:45
 **/
public class Q39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1 ){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
