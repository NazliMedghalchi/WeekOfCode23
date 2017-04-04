/**
 * Created by Nazli on 2017-03-15.
 */
/*
* Question source:http://www.lintcode.com/en/problem/interleaving-string/
* Solution source: http://www.jiuzhang.com/solutions/interleaving-string/
* */
public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        // interleaving condition
        if (l1 + l2 != l3)
            return false;

        boolean[][] dp = new boolean[l1+1][l2+2];
        dp[0][0] = true;

        // initializing the table based on first string
        for (int i = 1; i <= l1; i++){
            if (s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][0])
                dp[i][0] = true;
        }

        // initializing the table based on second string
        for (int i = 1; i <= l2; i++){
            if (s3.charAt(i-1) == s2.charAt(i-1) && dp[0][i-1])
                dp[0][i] = true;
        }

        for (int i = 1; i<=l1; i++){
            for (int j=1; j<=l2; j++){
                if (dp[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)) ||
                        dp[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1)))
                    dp[i][j] = true;
            }

        }
        return dp[l1][l2];
    }

}
