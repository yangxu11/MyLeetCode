package leetcode;

/**
 * 根据中序遍历和后序遍历还原二叉树
 *
 * @author yx
 * @create 2019-03-27  20:28
 **/
public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int[] in,int[] post,int inl,int inr,int postl,int postr){
        if(inl>inr) return null;
        if(inl==inr) return new TreeNode(in[inl]);
        int index = postl;
        for(int i=inl;i<=inr ; i++){
            if(in[i] == post[postr]){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(post[postr]);
        root.left = build(in,post,inl,index-1,postl,postl+index-inl-1);
        root.right = build(in,post,index+1,inr,postl+index-inl,postr-1);
        return root;
    }
}
