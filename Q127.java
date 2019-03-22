package leetcode;

import java.util.*;
//单词接龙
public class Q127 {
//超时答案， 构造单词map ， 广度优先搜索
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String,List<String>> map = new HashMap<>();
        if(!wordList.contains(beginWord))
            wordList.add(beginWord);
        for(int i=0 ; i<wordList.size() ; i++) {
            for(int j=i+1 ; j<wordList.size() ; j++) {
                if(onlyOneLetterDiff(wordList.get(i),wordList.get(j))) {
                    if(!map.containsKey(wordList.get(i))) {
                        map.put(wordList.get(i),new ArrayList<String>());
                    }
                    if(!map.containsKey(wordList.get(j))) {
                        map.put(wordList.get(j),new ArrayList<String>());
                    }
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        int count=1;
        int[] known = new int[wordList.size()];
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        known[wordList.indexOf(beginWord)]=1;
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i=0 ; i<size ; i++) {
                String now = queue.pop();
                List<String> sub = map.get(now);
                if(sub==null) break;
                known[wordList.indexOf(now)]=1;
                if(sub.contains(endWord)) return count;
                for(String str : sub){
                    if(known[wordList.indexOf(str)]==0) {
                        queue.offer(str);
                    }
                }
            }
        }
        return 0;


    }

    public boolean onlyOneLetterDiff(String word1, String word2) {
        if(word1.equals(word2)) return false;
        int len = word1.length();
        int count=0;
        for(int i=0 ; i<len ; i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
                if(count>1) return false;
            }
        }
        return true;
    }
}
