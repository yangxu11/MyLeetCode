package leetcode;
//验证二叉搜索树
public class Q98 {
    //100% 左子树要在[min,mid]之间，右子树要在[mid,max]之间  mid就为当前值
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        long mid = root.val;
        if(mid <= min || mid >= max){
            return false;
        }
        return isValid(root.left, min, mid) && isValid(root.right, mid, max);
    }
//50%  当前值小于右子树最小值，大于左子树最大值
    public boolean isValidBST1(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right == null) return true;
        if(root.left==null && root.right!=null) {
            if(root.val>=findMin(root.right)) return false;
            return isValidBST(root.right);
        }
        if(root.left!=null && root.right==null) {
            if(root.val<=findMax(root.left)) return false;
            return isValidBST(root.left);
        }
        if(root.left!=null && root.right!=null) {
            if(root.val>=findMin(root.right) || root.val<=findMax(root.left)) return false;
            return isValidBST(root.right) && isValidBST(root.left);
        }
        return true;
    }

    public int findMin(TreeNode root) {
        if(root==null) return 0;
        if(root.left == null) return root.val;
        return findMin(root.left);
    }

    public int findMax(TreeNode root) {
        if(root==null) return 0;
        if(root.right==null) return root.val;
        return findMax(root.right);
    }
}
