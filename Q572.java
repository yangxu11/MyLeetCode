package leetcode;

public class Q572 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null) return false;

        if(isSameTree(s,t)) {
            return true;
        }

        return isSubtree(s.left,t)||isSubtree(s.right,t);

    }

    public  boolean isSameTree(TreeNode tree1,TreeNode tree2){
        if (tree1==null&&tree2==null){//若两棵树均为空
            return true;
        }
        else if (tree1==null||tree2==null){//若两棵树有一方为空
            return false;
        }
        if(tree1!=null&&tree2!=null){
            if(tree1.val!=tree2.val){
                return false;
            }
            else {
                return isSameTree(tree1.left,tree2.left)&&isSameTree(tree1.right,tree2.right);
            }
        }
        return false;
    }

}
