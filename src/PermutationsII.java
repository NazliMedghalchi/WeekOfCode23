/**
 * Created by Nazli on 2017-01-09.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question source: http://www.lintcode.com/en/problem/permutations-ii/
 * Solution source: http://www.jiuzhang.com/solutions/permutations-ii/
 *                  https://github.com/shawnfan/LintCode/blob/master/Java/Permutations%20II.java
 * */
public class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();


        if (nums == null ) {
            return results;
        }
        if (nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }

        // visited element should be skipped
        int[] visited = new int[nums.length];
        ArrayList<Integer> permute = new ArrayList<Integer>();
        for (int i=0; i<visited.length; i++){
            visited[i] = 0;
        }
        Arrays.sort(nums);
        permutation(results, permute, nums, visited);
        return results;
    }

    public void permutation(List<List<Integer>> results, ArrayList<Integer> permute,
                            int[] nums, int[] visited){

        if ( permute.size() == nums.length) {
            results.add(new ArrayList<Integer>(permute));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i] == 1 || (i!=0 && visited[i-1] == 0
                    && nums[i] == nums[i-1])){
                continue;
            }

            visited[i] = 1;
            permute.add(nums[i]);
            permutation(results, permute, nums, visited);
            permute.remove(permute.size()-1);
            visited[i] = 0;

        }
    }
}



