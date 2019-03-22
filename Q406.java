package leetcode;

import java.util.Arrays;
import java.util.Comparator;
//根据身高重建队列
//先对其进行排序，身高降序排列，位置升序排列
//这样再从头遍历，每个都是当前身高最高的人，也是相对之前的最矮的人，它的插入不会影响之前排好的相对位置
//
public class Q406 {

    public static void main(String[] args) {
        Q406 q = new Q406();
        int[][] people = new int[][]{{7,1},{7,0},{5,2},{4,4},{5,0},{6,1}};
        people = q.reconstructQueue(people);
        for(int[] a : people){
            System.out.println(a[0]+","+a[1]);
        }
     }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator1());
        for(int i=0 ; i<people.length ; i++) {
            int index = people[i][1];
            int[] temp = people[i];
            for(int j=i ; j>index ; j--) {
                people[j] = people[j-1];
            }
            people[index] = temp;
        }
        return people;
    }

}

class Comparator1 implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int[] b) {
        return a[0]<b[0] ? 1 : (a[0]==b[0] ? (a[1]>b[1] ? 1 : (a[1]==b[1] ? 0 : -1)) : -1);
    }
}
