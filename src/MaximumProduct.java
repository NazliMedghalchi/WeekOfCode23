/**
 * Created by Nazli on 2017-01-23.
 */

/***
 * Question source: http://www.lintcode.com/en/problem/maximum-product-subarray/
 * Solution Source: http://www.jiuzhang.com/solutions/maximum-product-subarray/
 *
 *
 * */
public class MaximumProduct {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        int l = nums.length;
        int [] pos = new int[l];
        int [] neg = new int[l];

        pos[0] = nums[0];
        neg[0] = nums[0];
        int res = nums[0];
        for (int i =1; i < l; i++){
            pos[i] = neg[i] = nums[i];
            if (nums[i] > 0){
                pos[i] = Math.max(pos[i], pos[i-1] * nums[i]);
                neg[i] = Math.min(neg[i], neg[i-1] * nums[i]);
            }
            else{
                neg[i] = Math.min(neg[i], pos[i-1] * nums[i]);
                pos[i] = Math.max(pos[i], neg[i-1] * nums[i]);
            }
            res = Math.max(res, pos[i]);
        }
        return res;
    }

}
