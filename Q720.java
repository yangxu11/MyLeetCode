package leetcode;

/**
 * 字典中最长的单词
 *
 * @author yx
 * @create 2019-07-21  16:25
 **/
public class Q720 {

    //字典树经典题型
    class Node{
        char val;
        String word;
        Node[] next = new Node[26];
        public Node(char c){
            val = c;
        }
    }
    Node root = new Node('*');
    String res = "";
    public void insert(String word){
        Node node = root;
        for(int i=0 ; i<word.length() ; i++){
            char c = word.charAt(i);
            int index = c-'a';
            if(node.next[index]==null){
                node.next[index] = new Node(c);
            }
            node = node.next[index];
        }
        node.word = word;
    }

    public void dfs(Node root){
        if (root == null) {
            return;
        } else if (root.word != null) {
            if (res.length() < root.word.length())
                res = root.word;
        }
        for (Node node : root.next) {
            if (node != null && node.word != null)
                dfs(node);
        }
    }

    public String longestWord(String[] words) {
        if(words.length==0) return "";
        root.word = "";

        for(String word : words){
            insert(word);
        }

        dfs(root);

        return res;


    }
}
