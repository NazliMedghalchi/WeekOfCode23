/**
 * Created by Nazli on 2016-09-30.
 */
/**
 *@param nums: The integer array you should partition
 *@param k: As description
 *return: The index after partition
 */
public class PartiotionArray {
    public int partitionArray(int[] nums, int k) {
        //write your code here


        int ans = 0;
        if (nums == null || nums.length == 0)
            return ans;
        // Arrays.sort(nums);
        // for ( i=0; i<nums.length; i++) {
        //     if ( nums[i] == k)
        //         return i;
        // }
        // if (i == nums.length-1)
        //     return nums.length;
        // else
        //     return 0;

        int right = nums.length-1;
        int left = 0;
        int index = 0;
        while (left <= right) {
            while (left <= right && nums[left] < k)
                left++;
            while (left <= right && nums[right] >= k)
                right--;
            if (right >= left && nums[left] > nums[right]) {
                int n = nums[left];
                nums[left] = nums[right];
                nums[right] = n;
                left++;
                right--;
            }
        }
        ans = left;
        return ans;
    }
}
