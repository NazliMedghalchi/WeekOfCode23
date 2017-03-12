import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nazli on 2017-01-09.
 */

/**
 * Question Source: http://www.lintcode.com/en/problem/subsets/
 * Solution source: http://www.jiuzhang.com/solutions/subsets/
 *
 * */
public class SubsetsI {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        if (nums == null || nums.length == 0) return results;

        ArrayList<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(nums);
        int start = 0;

        combinations(nums, results, subset, start);
        return results;
    }

    public void combinations(int[] nums, ArrayList<ArrayList<Integer>> results,
                             ArrayList<Integer> subsets, int start){

        results.add(new ArrayList<Integer>(subsets));
        for (int i = start; i < nums.length; i++){
            subsets.add(nums[i]);
            combinations(nums, results, subsets, i+1);
            subsets.remove(subsets.size() - 1);
        }
    }
}
