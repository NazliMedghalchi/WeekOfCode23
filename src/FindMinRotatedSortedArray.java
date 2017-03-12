/**
 * Created by Nazli on 2016-10-10.
 */
/**
 * @param nums: a rotated sorted array
 * @return: the minimum number in the array
 */
public class FindMinRotatedSortedArray {
    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null)
            return -1;


        int size = nums.length;
        int start = 0;
        int end = size-1;
        // any smallest element has to  be before the last element
        int min = nums[size-1];

        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (nums[mid] <= min )
                end = mid;
            else
                start = mid;

        }

        if (nums[start] <= min) {
            return nums[start];
        }
        else
            return nums[end];
    }

}
