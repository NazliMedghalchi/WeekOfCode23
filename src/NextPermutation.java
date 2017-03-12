/**
 * Created by Nazli on 2016-11-06.
 */
/**
 * Question: http://www.lintcode.com/en/problem/next-permutation/
 * Solution source: http://www.jiuzhang.com/solutions/next-permutation/
 * */
public class NextPermutation {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return nums;

        for (int i = nums.length - 2; i >= 0; i--){
            // find increasing start point
            if (nums[i] < nums[i+1]){
                int j;
                // find increasing end point
                for (j = nums.length -1; j > i-1 ; j--) {
                    if (nums[j] > nums[i]){
                        break;
                    }
                }
                // swap values of i and j
                swap(nums, i, j);
                // reverse values from i+1 to length-1
                reverse(nums, i+1, nums.length -1);
                return nums;
            }
        }
        // reverse
        reverse(nums, 0, nums.length -1);
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start, int end){
        for(int s = start, e = end; s < e; s++, e-- ){
            swap(nums, s, e);
        }
    }
}
