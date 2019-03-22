package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//二叉树的最大宽度
public class Q662 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        Q662 q = new Q662();
        System.out.println(q.widthOfBinaryTree(root));
    }
//非递归方法
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        LinkedList<Tumple<Integer,TreeNode>> queue = new LinkedList<>();
        queue.add(new Tumple<>(0,root));
        int width = 1;
        while(!queue.isEmpty()) {
            int start = (int)queue.peek().getK();
            int end = (int)queue.get(queue.size()-1).getK();
            int number = queue.size();
            for(int i=0 ; i<number ; i++) {
                Tumple current = queue.pop();
                TreeNode currentNode = (TreeNode) current.getV();
                int currentIndex= (int)current.getK();
                if (currentNode.left != null) {
                        queue.add(new Tumple<>(currentIndex*2,currentNode.left));
                    }

                if (currentNode.right != null) {
                    queue.add(new Tumple<>(currentIndex*2+1,currentNode.right));
                }
            }
            width = Math.max(width,end-start+1);
        }
        return width;
    }

    //递归方法，记录每层首个节点的index，遍历求每层每个节点到该层首节点的距离，取最大值
    private int maxW = 0;

    public int widthOfBinaryTree2(TreeNode root) {
        /**
         假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
         用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
         节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
         加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
         **/
        dfs(root, 1, 1, new ArrayList<>());
        return maxW;
    }

    private void dfs(TreeNode r, int level, int index, List<Integer> left) {
        if(r == null) return;
        if(level > left.size()) left.add(index);
        maxW = Math.max(maxW, index - left.get(level-1) + 1);
        dfs(r.left, level+1, index*2, left);
        dfs(r.right, level+1, index*2+1, left);
    }

}

class Tumple<K,V> {
    K k;
    V v;
    public Tumple(K k,V v){
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }
}
