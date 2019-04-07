package leetcode;

/**
 * 实现前缀树
 *
 * @author yx
 * @create 2019-04-06  10:15
 **/
public class Q208 {

    class Trie {

        class Node{
            char val;
            boolean isWord;
            Node[] next;

            public Node(){
                this.val = '0';
                this.next = new Node[26];
                this.isWord = false;
            }
            public Node(char c){
                this.val = c;
                this.next = new Node[26];
                this.isWord = false;
            }
        }

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if(word.length()==0) return;

            Node node = root;

            for(int i=0 ; i<word.length() ; i++){
                char c = word.charAt(i);
                Node[] ts = node.next;
                if(ts[c-'a']==null){
                    ts[c-'a'] = new Node(c);
                }
                if(i==word.length()-1){
                    ts[c-'a'].isWord = true;
                }
                node = ts[c-'a'];
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = root;

            for(int i=0 ; i<word.length() ; i++){
                char c = word.charAt(i);
                Node[] ts = node.next;
                if(ts[c-'a']==null){
                    return false;
                }
                if(i==word.length()-1 && ts[c-'a'].isWord==true){
                    return true;
                }
                node = ts[c-'a'];
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = root;

            for(int i=0 ; i<prefix.length() ; i++){
                char c = prefix.charAt(i);
                Node[] ts = node.next;
                if(ts[c-'a']==null){
                    return false;
                }
                node = ts[c-'a'];
            }
            return true;
        }
    }

}
