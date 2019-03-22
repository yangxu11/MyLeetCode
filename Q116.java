package leetcode;
//填充同一层兄弟节点
public class Q116 {
    class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {
        if(root==null) return;

        if(root.left!=null) {
            root.left.next = root.right;
        } else {
            return;
        }
        TreeLinkNode leftnode = root.left;
        TreeLinkNode rightnode = root.right;
        while(leftnode.left!=null) {
            leftnode.right.next = rightnode.left;
            leftnode = leftnode.right;
            rightnode = rightnode.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
