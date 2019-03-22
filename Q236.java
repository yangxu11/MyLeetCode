package leetcode;
//二叉树最近的公共祖先
public class Q236 {
    /*超时解法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(containsElement(root.left,p)&&containsElement(root.left,q)) {
            return lowestCommonAncestor(root.left,p,q);
        } else if(containsElement(root.right,p)&&containsElement(root.right,q)) {
            return lowestCommonAncestor(root.right,p,q);
        } else {
            return root;
        }
    }
    public boolean containsElement(TreeNode root,TreeNode t) {
        if(root==null) return false;
        if(root.val == t.val) return true;
        boolean x = containsElement(root.left,t);
        boolean y = containsElement(root.right,t);
        return x||y;
    }
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==q || root==p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) {
            return root;
        }
        return left!=null ? left : right;
    }

}
