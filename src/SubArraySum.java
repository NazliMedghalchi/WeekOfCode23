/**
 * Created by Nazli on 2016-09-27.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @param nums: A list of integers
 * @return: A list of integers includes the index of the first number
 *          and the index of the last number
 */
public class SubArraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        // check for exceptions before running the program
        ArrayList<Integer> subArr = new ArrayList<Integer>();
        if (nums.length == 0 || nums == null)
            return subArr;

        int i = 0;
        // pointer to start of subarray
        int k = 0;
        //  pointer to end of subarray
        int j = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Initialize the hashmap
        map.put(0, -1);

        for (int n=0; n < nums.length; n++) {
            // the sum will be zero if there exist the opposite value of sum in the hashmap
            sum += nums[n];
            if (map.containsKey(sum)) {
                subArr.add(map.get(sum)+1);
                subArr.add(n);
                return subArr;
            }
            map.put(sum, n);
        }

        return subArr;

/*        2nd method:

         while ( i < nums.length) {
             sum = nums[i];
             if (nums[i] == 0) {
                 subArr.add(i);
                 subArr.add(i);
                 return subArr;
             }
        for (int n=0; n < nums.length; n++) {
            // the sum will be zero if there exist the opposite value of sum in the hashmap
            sum += nums[n];
            if (map.containsKey(sum)) {
                subArr.add(map.get(sum)+1);
                subArr.add(n);
                return subArr;
            }
             if (sum == 0) {
                 subArr.add(i);
                 subArr.add(n);
                 return subArr;
             }
        }
         i++;
         }
        return subArr;
        */
    }

}
