/**
 * Created by Nazli on 2017-03-15.
 */
/*
* Question source: http://www.lintcode.com/en/problem/longest-consecutive-sequence/
* Solution source: http://www.jiuzhang.com/solutions/longest-consecutive-sequence/
* */
public class LongestConsecutivesSeq {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<Integer>();
        if (num == null || num.length == 0)
            return 0;

        for (int i = 0; i < num.length; i++){
            set.add(num[i]);
        }

        int longestSeq = 0;
        for (int i = 0; i < num.length; i++){
            // check lower numbers
            int down = num[i]-1;
            while (set.contains(down)){
                set.remove(down);
                down--;
            }
            // check upper values of evry element in the set
            int up = num[i]+1;
            while (set.contains(up)){
                set.remove(up);
                up++;
            }

            longestSeq = Math.max(longestSeq, up - down -1);
        }
        return longestSeq;
    }
}
