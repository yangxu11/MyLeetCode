package leetcode;
//二叉树原地转换成链表
public class Q114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null  && root.left.left==null) {

            TreeNode node = root.left;
            TreeNode temp = root.right;
            root.right = node;
            TreeNode last = findLastRight(node);
            last.right = temp;
            root.left=null;
        }
        return;
    }
    public TreeNode findLastRight(TreeNode root) {
        if(root==null) return null;
        while(root.right!=null) {
            root = root.right;
        }
        return root;
    }
}
