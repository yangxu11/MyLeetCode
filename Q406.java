package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//根据身高重建队列
//先对其进行排序，身高降序排列，位置升序排列
//这样再从头遍历，每个都是当前身高最高的人，也是相对之前的最矮的人，它的插入不会影响之前排好的相对位置
//
public class Q406 {

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

    //对people排序，身高升序，位置升序，从末尾遍历，

    public int[][] reconstructQueue2(int[][] people) {
        if(people.length==0) return people;

        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                int x = a[1]>b[1] ? 1 : (a[1]==b[1] ? 0 : -1);
                return a[0]>b[0] ? 1 : (a[0]==b[0] ? x : -1);
            }
        };

        Arrays.sort(people,comp);

        List<int[]> res = new ArrayList<>();

        for(int i=people.length-1 ; i>=0 ; i--){
            int index = i;
            while(i>0 && people[i-1][0]==people[i][0]){
                --i;
            }
            for(int j=i ; j<=index ; j++){
                res.add(people[j][1],people[j]);
            }
        }
        int[][] ans = new int[people.length][2];
        int index = 0;
        for(int[] num : res){
            ans[index] = num;
            index++;
        }
        return ans;
    }


}

class Comparator1 implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int[] b) {
        return a[0]<b[0] ? 1 : (a[0]==b[0] ? (a[1]>b[1] ? 1 : (a[1]==b[1] ? 0 : -1)) : -1);
    }
}
