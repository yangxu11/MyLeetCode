package leetcode.offer;

/**
 * 树的子结构
 *
 * @author yx
 * @create 2019-05-04  10:22
 **/
public class Q17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) return false;
        return search(root1,root2) || search(root1.left,root2) || search(root1.right,root2);
    }

    public boolean search(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;

        if(root1.val != root2.val){
            return false;
        }
        return search(root1.left,root2.left) && search(root1.right,root2.right);
    }
}
