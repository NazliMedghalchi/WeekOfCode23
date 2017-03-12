/**
 * Created by Nazli on 2016-10-04.
 */
/**
 * @param matrix, a list of lists of integers
 * @param target, an integer
 * @return a boolean, indicate whether matrix contains target
 */
public class SearchTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        // double binary search on matrix
        // first find the possible row
        // second search on the row

        if (matrix.length == 0 || matrix == null)
            return false;
        if (matrix[0].length == 0 || matrix[0] == null)
            return false;

        // find the row
        int n = matrix.length; //row
        int m = matrix[0].length; //column
        int left = 0;
        int right = n - 1;
        int row =0;
        while (left +1 < right) {
            int mid = left + (right - left)/2;
            if (matrix[mid][0] == target ) {
                return true;
            }
            else if (matrix[mid][0] < target)
                left = mid;
            else
                right = mid;
        }

        if (matrix[right][0] <= target)
            row = right;
        else if (matrix[left][0] <= target )
            row = left;
        else
            return false; //row = end+1;


        // find column
        int leftCol = 0;
        int rightCol = m -1;
        int col = 0;

        while (leftCol + 1 < rightCol) {
            int midCol = leftCol + (rightCol - leftCol) / 2;
            if (matrix[row][midCol] == target)
                return true; //col = mid;
            else if (matrix[row][midCol] < target)
                leftCol = midCol;
            else
                rightCol = midCol;
        }

        if (matrix[row][leftCol] == target)
            return true; //col = leftCol;
        else if (matrix[row][rightCol] == target)
            return true; //col = rightCol;

        return false; //col = rightCol+1; outOf boundry


        // binary search on entire matrix
//        int start = 0;
//        int end = n*m-1;
//
//        while (start + 1 < end) {
//            int mid = start + (end - start) / 2;
//            int num = matrix[mid / m][mid % m];
//            if (num == target)
//                return true;
//            else if (num < target)
//                start = mid;
//            else
//                end = mid;
//        }
//        if (matrix[end / m][end % m] == target)
//            return true;
//        else if (matrix[start / m][start % m] == target)
//            return true;
//        return false;

    }

}
