import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazli on 2017-01-09.
 */
/**
 * Question Source: http://www.lintcode.com/en/problem/permutations/
 * Solution source: http://www.jiuzhang.com/solutions/permutations/
 * */
public class Permutation {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> list = new ArrayList< List<Integer>>();

        if (nums == null) {
            return list;
        }
        List<Integer> permuteElement = new ArrayList<Integer>();

        if (nums.length == 0){

            list.add(new ArrayList<Integer>());
            return list;
        }

        permuteHelp(nums, list, permuteElement);
        return list;
    }

    public void permuteHelp(int[] nums, List<List<Integer>> list, List<Integer> permuteElement){
        if (permuteElement.size() == nums.length){
            list.add(new ArrayList<Integer>(permuteElement));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if (permuteElement.contains(nums[i])) {
                continue;
            }
            permuteElement.add(nums[i]);
            permuteHelp(nums, list, permuteElement);
            permuteElement.remove(permuteElement.size() - 1);
        }
    }
}
