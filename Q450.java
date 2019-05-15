package leetcode;

/**
 * 删除二叉树中的节点
 *
 * @author yx
 * @create 2019-05-15  10:16
 **/
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val<key){
            root.right = deleteNode(root.right,key);
        } else if(root.val>key){
            root.left = deleteNode(root.left,key);
        } else if(root.left!=null && root.right!=null){
            root.val = findMin(root.right).val;
            root.right = deleteNode(root.right,root.val);
        } else{
            root= root.left==null ? root.right : root.left;
        }
        return root;
    }
    private TreeNode findMin(TreeNode root){
        synchronized(this){
            if(root==null) return null;
            if(root.left==null) return root;
            return findMin(root.left);
        }

    }
}
