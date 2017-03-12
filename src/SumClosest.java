/**
 * Created by Nazli on 2016-09-29.
 */

import java.util.Arrays;

/**
 * @param numbers: Give an array numbers of n integer
 * @param target : An integer
 * @return : return the sum of the three integers, the sum closest target.
 */
/* Find 3 elements that their sum is closest to target */
public class SumClosest {

    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        // counter to find the closest value
        if (numbers.length < 3 || numbers == null)
            return -1;

// Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        Arrays.sort(numbers);
        int minOpt = numbers[0] + numbers[1] + numbers[2];
        int sum;
        for (int i=0; i<numbers.length; i++) {
            // int k = 0;
            int s=i+1;
            int t=numbers.length -1;
            // ArrayList<Integer> arr = new ArrayList<Integer>();
            while (s<t) {
                sum = numbers[i] + numbers[s] + numbers[t];
                if (Math.abs(sum-target) < Math.abs(minOpt-target))
                    minOpt = sum;
                if (sum <= minOpt)
                    s++;
                else
                    t--;
            }
        }
        return minOpt;
    }


}
