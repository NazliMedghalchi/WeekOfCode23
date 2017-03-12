/**
 * Created by Nazli on 2016-09-30.
 */
    /*
         * @param numbers : An array of Integer
         * @param target : target = numbers[index1] + numbers[index2]
         * @return : [index1 + 1, index2 + 1] (index1 < index2)
         */
public class twoSum {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] ans = new int[2];
        if (numbers.length < 2 || numbers == null)
            return ans;

        for (int i = 0 ; i<numbers.length-1; i++) {
            int j = numbers.length-1;
            while (i<j) {
                int sum = numbers[i] + numbers[j];
                if ( sum == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
                j--;
            }
        }
        return ans;
    }

}
