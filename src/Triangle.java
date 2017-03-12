/**
 * Created by Nazli on 2017-01-21.
 */
/**
 * Question Source: http://www.lintcode.com/en/problem/triangle/
 * Solution Source: http://www.jiuzhang.com/solutions/triangle/
 *
 * */
public class Triangle {

        /**
         * @param triangle: a list of lists of integers.
         * @return: An integer, minimum path sum.
         */
        public int minimumTotal(int[][] triangle) {
            // write your code here

            if (triangle == null || triangle.length == 0 )
                return -1;
            if (triangle[0] == null || triangle[0].length == 0)
                return -1;
            // Stack stack = new Stack();

            // int index = 0;
            // while (triangle != null){
            //     stack.add(triangle[index]);
            //     index++;
            //     int min = Integer.MIN_VALUE;
            //     for (int i = 0; i< triangle[0].length; i++){
            //         if (triangle[index][i] < min){
            //             min = triangle[index][i];
            //         }

            //     }


            //     index++;
            //     minPath += min;
            // }


            int l = triangle.length;
            int[][] minArray = new int[l][l];
            minArray[0][0] = triangle[0][0];
            // Initialize
            for (int i = 1; i<l ; i++){
                minArray[i][0] = minArray[i-1][0] + triangle[i][0];
                minArray[i][i] = minArray[i-1][i-1] + triangle[i][i];
            }

            // top-down filling DP
            for (int j = 1; j<l; j++){
                for (int k = 1; k<j; k++){
                    minArray[j][k] = Math.min(minArray[j-1][k], minArray[j-1][k-1]) + triangle[j][k];
                }
            }
            int bestSol = minArray[l-1][0];
            for (int i =0; i<l; i++){
                bestSol = Math.min(minArray[l-1][i], bestSol);
            }
            return bestSol;
        }

}
