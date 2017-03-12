/**
 * Created by Nazli on 2016-11-03.
 */
/**
 * Question: http://www.lintcode.com/en/problem/majority-number/
 * Solution src: https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72995
 * */


import java.util.ArrayList;

public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }

        int k = nums.size() / 2;
        int n = -1;
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                n = nums.get(i);
                count++;
            }
            else if (n == nums.get(i)){
                count++;
            }
            else {
                count--;
            }
        }
        return n;
    }

}
