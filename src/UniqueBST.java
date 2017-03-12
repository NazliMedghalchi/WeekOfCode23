/**
 * Created by Nazli on 2016-10-27.
 */
/**
 * @paramn n: An integer
 * @return: An integer
 */
/**
 * Question from lintcode CH4
 * Source code:
 *http://www.jiuzhang.com/solutions/fast-power/
 *
 * **/
public class UniqueBST {

    public int numTrees(int n) {
        // write your code here
        int[] count = new int[n+1];
        if (n == 1 || n == 0)
            return 1;

        count[0] = 1;
        count[1] = 1;
        for (int i=2; i<n+1; i++) {
            for (int j=0; j<i; j++){
                count[i] += count[j] * count[i-j-1];
            }
        }

        return count[n];
    }

}
