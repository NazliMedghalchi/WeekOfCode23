/**
 * Created by Nazli on 2016-11-03.
 */
/**
* Question: http://www.lintcode.com/en/problem/maximum-subarray/
*   Solution source: http://www.jiuzhang.com/solutions/maximum-subarray/
* */
public class MaxSubArray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0)
            return -1;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum = Math.max(sum, 0);
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
