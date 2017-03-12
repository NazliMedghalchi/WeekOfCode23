/**
 * Created by Nazli on 2016-10-02.
 */
/**
 * @param nums: The integer array.
 * @param target: Target to find.
 * @return: The first position of target. Position starts from 0.
 */
public class FirstPositionofTarget {

    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0)
            return -1;
        int s =0;
        int e = nums.length-1;

        while (s +1 < e) {
            int mid = s + (e - s) /2;
            if (nums[mid] >= target) {
                e = mid;
            }
            else if (nums[mid] < target )
                s = mid;

        }

        if (nums[s] == target)
            return s;
        else if (nums[e] == target)
            return e;

        return -1;
    }

}
