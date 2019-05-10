package leetcode.offer;

/**
 * 对称的二叉树
 *
 * @author yx
 * @create 2019-05-10  17:16
 **/
public class Q58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        return isSame(pRoot.left,pRoot.right);
    }
    private boolean isSame(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left!=null && right==null) return false;
        if(left==null && right!=null) return false;
        if(left.val!=right.val) return false;
        return isSame(left.right,right.left) && isSame(left.left,right.right);
    }
}
