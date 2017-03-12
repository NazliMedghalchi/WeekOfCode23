/**
 * Created by Nazli on 2016-10-13.
 */
/**
 * @param n, m: positive integer (1 <= n ,m <= 100)
 * @return an integer
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // write your code here

        int[][] area = new int[m][n];

        for (int i=0; i<m; i++){
            area[i][0] = 1;
        }
        for (int j=0; j<n ; j++){
            area[0][j] = 1;
        }

        for (int k=1; k<m; k++) {
            for (int l=1; l<n; l++) {
                area[k][l] = area[k-1][l] + area[k][l-1];
            }
        }
        return area[m-1][n-1];
    }


}
