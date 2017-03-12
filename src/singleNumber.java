/**
 * Created by Nazli on 2016-11-03.
 */
/**
 *@param A : an integer array
 *return : a integer
 */

/**
 * Question: http://www.lintcode.com/en/problem/single-number/
 * Solution src: http://www.jiuzhang.com/solutions/single-number-ii/
 * */
public class singleNumber {

    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0 ){
            return 0;
        }
        int n = A[0];
        for (int i = 1; i < A.length; i++) {
            n = n ^ A[i];
        }
        return n;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i = 0; i < A.length; i++) {
        //     if (!map.containsKey(A[i])) {
        //         map.put(A[i], 1);
        //     }
        //     else {
        //         map.put(A[i], map.get(A[i]) + 1);
        //     }
        // }
        // return map.get(map.containsValue(1));
    }

}
