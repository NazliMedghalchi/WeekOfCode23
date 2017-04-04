/**
 * Created by Nazli on 2017-03-14.
 */
/*
* Question source: http://www.lintcode.com/en/problem/backpack/
* Solution source: http://www.jiuzhang.com/solutions/backpack/
* */
public class BackPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here

        // m = max weight of knapsack
        // A includes all weigths
        // A.length() is the number of items

        if (m == 0 || A.length == 0)
            return 0;

        int items = A.length;
        boolean[][] dp = new boolean[items+1][m+1];

        for (int i = 0; i <= items; i++){
            for (int j = 0; j <= m; j++){
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;

        for (int i = 1; i <= items; i++){
            for (int w = 0; w <= m; w++){
                dp[i][w] = dp[i-1][w];
                if (w >= A[i-1] && dp[i-1][w-A[i-1]])
                    dp[i][w] = true;
            }
        }

        for (int j = m; j >=0; j--){
            if (dp[items][j] == true)
                return j;
        }
        return 0;
    }
}
