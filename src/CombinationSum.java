/**
 * Created by Nazli on 2017-01-04.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question Source:
 * Solution Source: https://github.com/shawnfan/LintCode/blob/master/Java/Combination%20Sum%20II.java
 *                  http://www.jiuzhang.com/solutions/combination-sum/
 *
 * */
public class CombinationSum {
        /**
         * @param candidates: A list of integers
         * @param target:An integer
         * @return: A list of lists of integers
         */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<Integer> num = new ArrayList<Integer>();
        List<List<Integer>> numSet = new ArrayList<List<Integer>>();

        if (target == 0 || candidates.length == 0){
            return numSet;
        }
        int start = 0;
        int sum = 0;
        Arrays.sort(candidates);
        helper(num, numSet, candidates, target, start, sum);
        return numSet;
    }

    public void helper(List<Integer> num, List<List<Integer>> numSet,
                       int[] candidates, int target, int start, int sum) {


        if (target == 0) {
            numSet.add(new ArrayList<Integer>(num));
            return;
        }
        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }

            sum += candidates[i];
            num.add(candidates[i]);
            helper(num, numSet, candidates, target - candidates[i], i, sum);
            num.remove(num.size() - 1);
            prev = candidates[i];
            // for (int j=i; j<candidate.length; j++){
            //     while (sum <= target) {
            //         sum += candidates[j];
            //         if (sum > target){
            //             helper(num, numSet, candidates, target, start+1);
            //         }
            //     }
            // }
        }
    }
}
