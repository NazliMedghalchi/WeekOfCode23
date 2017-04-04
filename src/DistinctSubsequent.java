/**
 * Created by Nazli on 2017-03-12.
 */

/*
* Question source: http://www.lintcode.com/en/problem/distinct-subsequences/
* Solution source: http://www.jiuzhang.com/solutions/distinct-subsequences/
*
* */
public class DistinctSubsequent {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
    */
    public int numDistinct(String S, String T) {
        // write your code here
        int ls = S.length();
        int lt = T.length();

        if (S == null || T == null)
            return 0;

        int[][] dp = new int[ls+1][lt+1];
        for (int i = 0; i < ls+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= lt; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i<ls+1; i++){
            for (int j = 1; j<lt+1; j++){
                dp[i][j] = dp[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        }
        return dp[ls][lt];
    }
}
