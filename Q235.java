package leetcode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author yx
 * @create 2019-04-11  16:15
 **/
public class Q235 {
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if((root.val>=p.val && root.val<=q.val)||(root.val<=p.val && root.val>=q.val))
            return root;
        if(root.val<p.val && root.val<q.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }

        return null;
    }
    //非递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;
        while(node!=null){
            if(node.val<qVal && node.val<pVal){
                node = node.right;
            } else if(node.val>qVal && node.val>pVal){
                node = node.left;
            } else{
                return node;
            }
        }
        return null;

    }
}
