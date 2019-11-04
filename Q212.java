package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索II
 *
 * @author yx
 * @create 2019-10-31  20:24
 **/
public class Q212 {

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board =
                {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

        Q212 q = new Q212();
        System.out.println(q.findWords(board,words));
    }

    class Node{
        char val;
        Node[] next;
        boolean isEnd;
        String str;

        Node(char val){
            this.val = val;
            isEnd = false;
            next = new Node[26];
        }
    }

    Node root = new Node('#');

    public void getTree(String s){
        Node node = root;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(node.next[c-'a']==null){
                Node tmp = new Node(c);
                node.next[c-'a'] = tmp;
            }
            node = node.next[c-'a'];
        }
        node.isEnd = true;
        node.str = s;
    }
    Set<String> res = new HashSet<>();
    int xlen,ylen;
    public List<String> findWords(char[][] board, String[] words) {

        xlen = board.length;
        if(xlen==0) return new ArrayList<>();
        ylen = board[0].length;
        if(ylen==0) return new ArrayList<>();

        if(words.length==0) return new ArrayList<>();

        for(String word:words){
            getTree(word);
        }
        for(int i=0 ; i<xlen ; i++){
            for(int j=0 ; j<ylen ; j++){
                dfs(root.next,board,i,j,new boolean[xlen][ylen]);
            }
        }


        return new ArrayList<>(res);
    }
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(Node[] nodes,char[][] board,int x,int y,boolean[][] visited){
        if(x<0 || x>=xlen || y<0 || y>=ylen || visited[x][y]){
            return;
        }
        visited[x][y] = true;
        char c = board[x][y];
        if(nodes[c-'a']!=null){
            Node node = nodes[c-'a'];
            if(node.isEnd){
                res.add(node.str);
            }
            for(int[] dir : dirs){
                int i = x + dir[0];
                int j = y + dir[1];
                dfs(node.next,board,i,j,visited);
            }
        }
        visited[x][y] = false;
    }
}
