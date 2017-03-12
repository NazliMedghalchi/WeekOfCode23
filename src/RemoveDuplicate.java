/**
 * Created by Nazli on 2016-09-29.
 */
/**
 * @param A: a array of integers
 * @return : return an integer
 */
public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        // write your code here

//        if the array is empty return 0
        if (nums == null || nums.length == 0 )
            return 0;
//      if for any 2 neightbor elements are not same copy the element to next position (++j)
//       return vlalue has to be j+1 cause the length is +1 of the last index

        int j=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

}
