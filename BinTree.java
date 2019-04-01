package  leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinTree {
    private char date;
    private BinTree lchild;
    private BinTree rchild;

    public BinTree(char c) {
        date = c;
    }

    // 先序遍历递归
    public static void preOrder(BinTree t) {
        if (t == null) {
            return;
        }
        System.out.print(t.date);
        preOrder(t.lchild);
        preOrder(t.rchild);
    }

    // 中序遍历递归
    public static void InOrder(BinTree t) {
        if (t == null) {
            return;
        }
        InOrder(t.lchild);
        System.out.print(t.date);
        InOrder(t.rchild);
    }

    // 后序遍历递归
    public static void PostOrder(BinTree t) {
        if (t == null) {
            return;
        }
        PostOrder(t.lchild);
        PostOrder(t.rchild);
        System.out.print(t.date);
    }

    // 先序遍历非递归
    public static void preOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<BinTree>();
        while (t != null || !s.empty()) {
            while (t != null) {
                System.out.print(t.date);
                s.push(t);
                t = t.lchild;
            }
            if (!s.empty()) {
                t = s.pop();
                t = t.rchild;
            }
        }
    }

    // 中序遍历非递归
    public static void InOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<BinTree>();
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                t = t.lchild;
            }
            if (!s.empty()) {
                t = s.pop();
                System.out.print(t.date);
                t = t.rchild;
            }
        }
    }

    //中序遍历非递归 常数空间
    //使用最右面的节点的右节点来存储上一层的根
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        TreeNode tmp;
        while(node!=null){
            if(node.left == null){
                list.add(node.val);
                node = node.right;
            } else {
                tmp = node.left;
                while(tmp.right!=null && tmp.right!=node){
                    tmp = tmp.right;
                }
                if(tmp.right==null){//将上一层的根node存在最右面节点的右子树
                    tmp.right = node;
                    node = node.left;
                } else {//左子树遍历完，重新找到了上一层的根，遍历其右子树
                    list.add(node.val);
                    tmp.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }

    // 后序遍历非递归
    public static void PostOrder2(BinTree t) {
        Stack<BinTree> s = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Integer i = new Integer(1);
        while (t != null || !s.empty()) {
            while (t != null) {
                s.push(t);
                s2.push(new Integer(0));
                t = t.lchild;
            }
            while (!s.empty() && s2.peek().equals(i)) {
                s2.pop();
                System.out.print(s.pop().date);
            }

            if (!s.empty()) {
                s2.pop();
                s2.push(new Integer(1));
                t = s.peek();
                t = t.rchild;
            }
        }
    }

    //层序遍历

    public static void laywer(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode currentNode;
        while(!list.isEmpty()) {
            currentNode = list.poll();
            System.out.print(currentNode.val);
            if(currentNode.left != null) {
                list.add(currentNode.left);
            }
            if(currentNode.right != null) {
                list.add(currentNode.right);
            }

        }

    }

    public static void main(String[] args) {
        BinTree b1 = new BinTree('a');
        BinTree b2 = new BinTree('b');
        BinTree b3 = new BinTree('c');
        BinTree b4 = new BinTree('d');
        BinTree b5 = new BinTree('e');

        /**
         *      a
         *     / /
         *    b   c
         *   / /
         *  d   e
         */
        b1.lchild = b2;
        b1.rchild = b3;
        b2.lchild = b4;
        b2.rchild = b5;

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(BinTree.inorderTraversal2(root));

    }
}
