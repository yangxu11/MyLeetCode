package leetcode;

import java.util.ArrayList;
import java.util.List;
//添加与搜索单词 - 数据结构设计
public class Q211 {
    //执行用时: 261 ms, 在Add and Search Word - Data structure design的Java提交中击败了37.59% 的用户
    //内存消耗: 106.4 MB, 在Add and Search Word - Data structure design的Java提交中击败了0.00% 的用户

    //字典树的设计
    class WordDictionary {
        class TrieNode{
            int prefix_Num;
            TrieNode[] child;
            boolean isLeaf;
            public TrieNode(){
                isLeaf=false;
                prefix_Num = 1;
                child = new TrieNode[26];
            }
        }

        TrieNode troot;
        /** Initialize your data structure here. */
        public WordDictionary() {
            troot = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode root = troot;
            char[] letters = word.toCharArray();
            for(int i=0 ; i<letters.length ; i++){
                int index = letters[i]-'a';
                if(root.child[index]!=null){
                    root.child[index].prefix_Num++;
                } else {
                    root.child[index] = new TrieNode();
                }
                root = root.child[index];
            }
            root.isLeaf=true;
        }

        //执行用时: 201 ms, 在Add and Search Word - Data structure design的Java提交中击败了68.23% 的用户
        //内存消耗: 91 MB, 在Add and Search Word - Data structure design的Java提交中击败了7.07% 的用户
        //递归搜索
        public boolean search1(String word) {
            char[] letters = word.toCharArray();
            return match(troot,letters,0);
        }

        public boolean match(TrieNode root,char[] letters,int index){
            if(index==letters.length) return root.isLeaf;
            if(letters[index]=='.'){
                for(TrieNode node : root.child){
                    if(node!=null && match(node,letters,index+1)){
                        return true;
                    }
                }
                return false;
            } else {
                return root.child[letters[index]-'a']!=null &&match(root.child[letters[index]-'a'],letters,index+1);
            }

        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        //非递归搜索
        public boolean search(String word) {
            char[] letters = word.toCharArray();
            List<TrieNode> temp = new ArrayList<>();
            temp.add(troot);
            for(int i=0 ; i<letters.length ; i++){
                List<TrieNode> list = new ArrayList<>();
                int endFlag = 0;
                if(letters[i]=='.'){
                    for(TrieNode node : temp){
                        for(TrieNode ch : node.child){
                            if(ch!=null){
                                list.add(ch);
                            }
                        }
                    }
                } else {
                    int index = letters[i]-'a';
                    for(TrieNode node : temp){
                        if(node.child[index]!=null){
                            list.add(node.child[index]);
                        }
                    }
                }
                if(list==null) return false;
                temp = list;
            }
            for(TrieNode node : temp){
                if(node.isLeaf){
                    return true;
                }
            }
            return false;
        }
    }
}
