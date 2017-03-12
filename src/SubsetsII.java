import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nazli on 2017-01-09.
 */

/**
 * Question source: http://www.lintcode.com/en/problem/subsets-ii/
 * Solution source: http://www.jiuzhang.com/solutions/subsets-ii/
 *
 * */
public class SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();

        if (nums == null || nums.length == 0){
            return subsets;
        }

        Arrays.sort(nums);
        // ArrayList<Integer> noDuplicates = new ArrayList<Integer>();
        // findDuplicates(nums, noDuplicates);
        // createSubsets(subsets, noDuplicates, nums);
        int k = 0;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        combination(nums, subsets, sub, k);
        return subsets;
    }


    public void combination(int[] nums, ArrayList<ArrayList<Integer>> subsets,
                            ArrayList<Integer> sub, int k) {

        subsets.add(new ArrayList<Integer>(sub));

        for (int i = k; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && i > k){
                continue;
            }

            sub.add(nums[i]);
            combination(nums, subsets, sub, i+1);
            sub.remove(sub.size()-1);
        }
    }

    public void findDuplicates(int[] nums, ArrayList<Integer> noDuplicates){
        noDuplicates.add(nums[0]);

        for (int i = 0; i < nums.length; i++){
            if (noDuplicates.contains(nums[i])){
                continue;
            }
            noDuplicates.add(nums[i]);
        }
        // System.out.println(noDuplicates);
    }

    public void createSubsets(ArrayList<ArrayList<Integer>> subsets,
                              ArrayList<Integer> noDuplicates,
                              int[] nums){


    /* Any set is its own subset */
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i<nums.length; i++){
            temp.add(nums[i]);
        }
        subsets.add(temp);

    /* null subset*/
        subsets.add(new ArrayList<Integer>());

    /* Individual memebers*/
        if (nums.length > 1){
            int count = 0;
            ArrayList<Integer> dup = noDuplicates;
            while(count <  noDuplicates.size()){
                ArrayList<Integer> ind = new ArrayList<Integer>();
                ind.add(dup.get(count));
                subsets.add(ind);
                count++;
            }

        /* for combinations of 2, 3, ..., n-1 memebrs*/
            int k = 0;
            ArrayList<Integer> sub = new ArrayList<Integer>();
            combination(nums, subsets, sub, k);
        }
    }

}
