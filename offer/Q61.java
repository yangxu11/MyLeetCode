package leetcode.offer;

/**
 * 序列化二叉树
 *
 * @author yx
 * @create 2019-05-13  19:35
 **/
public class Q61 {
    String Serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        serial(root,sb);
        return sb.toString();
    }
    private void serial(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val+",");
        serial(root.left,sb);
        serial(root.right,sb);
    }
    TreeNode Deserialize(String str) {
        if(str.length()==0) return null;
        String[] strs = str.split(",");
        return deserial(strs);
    }
    int index = -1;
    private TreeNode deserial(String[] strs){
        index++;
        if(strs[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
        root.left = deserial(strs);
        root.right = deserial(strs);
        return root;
    }
}
