package leetcode;
//二叉树原地转换成链表
public class Q114 {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        while(root.left!=null){
            TreeNode node = root.left;
            while(node.right!=null){
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left=null;
        }
    }
}
