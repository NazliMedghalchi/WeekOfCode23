/**
 * Created by Nazli on 2017-01-11.
 */

/**
 * Question Source: http://www.lintcode.com/en/problem/unique-paths-ii/
 * Solution source: http://www.jiuzhang.com/solutions/unique-paths-ii/
 * */
public class UniquePathsII {
        /**
         * @param obstacleGrid: A list of lists of integers
         * @return: An integer
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // write your code here
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
                return 0;
            }
            int m  = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] sum = new int[m][n];


            for (int i = 0; i<m; i++){
                if (obstacleGrid[i][0] != 1){
                    sum[i][0] = 1;
                }
                else {
                    break;
                }
            }
            for (int j = 0; j<n; j++){
                if (obstacleGrid[0][j] != 1){
                    sum[0][j] = 1;
                }
                else {
                    break;
                }
            }

            for (int r=1; r<m; r++){
                for (int c =1 ; c<n ; c++){
                    if (obstacleGrid[r][c] != 1)
                        sum[r][c] = sum[r-1][c] + sum[r][c-1];
                    else
                        sum[r][c] = 0;
                }
            }
            return sum[m-1][n-1];
        }

}
