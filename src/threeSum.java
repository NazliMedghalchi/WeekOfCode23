/**
 * Created by Nazli on 2016-09-30.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @param numbers : Give an array numbers of n integer
 * @return : Find all unique triplets in the array which gives the sum of zero.
 */
public class threeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        if (numbers == null || numbers.length < 3)
            return arr;
        Arrays.sort(numbers);

        for (int i=0; i<numbers.length-2; i++) {
            // int k = 0;

            if (i != 0 && numbers[i] == numbers[i-1])
                continue;
            int sum = 0;
            int left = i+1;
            int right = numbers.length-1;
            while (left < right) {
                sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    n.add(numbers[i]);
                    n.add(numbers[left]);
                    n.add(numbers[right]);
                    arr.add(n);
                    left++;
                    right--;
                    while (numbers[left] == numbers[left-1] && left < right)
                        left++;
                    // while (left < right && numbers[right] == numbers[right+1] )
                    //     right++;
                }
                else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return arr;
    }

}
