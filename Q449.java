package leetcode;
/*
 * @Author YX
 *  序列化和反序列化二叉搜索树
 * @Date 21:31 2019/5/21
 **/
public class Q449 {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serial(root);
        return sb.toString();
    }
    private void serial(TreeNode root){
        if(root==null) return ;
        sb.append(root.val+";");
        serial(root.left);
        serial(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() ==0) return null;

        String[] strs = data.split(";");

        return deserial(strs,0,strs.length-1);
    }

    private TreeNode deserial(String[] strs,int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(Integer.parseInt(strs[start]));
        int num = Integer.parseInt(strs[start]);
        TreeNode root = new TreeNode(num);
        int index = end+1;
        for(int i=start+1 ; i<=end ; i++){
            if(Integer.parseInt(strs[i]) > num){
                index = i;
                break;
            }
        }
        root.left = deserial(strs,start+1,index-1);
        root.right = deserial(strs,index,end);

        return root;
    }
}
