/**
 * Created by Nazli on 2016-10-13.
 */
/**
 *@param A : an integer rotated sorted array
 *@param target :  an integer to be searched
 *return : an integer
 */
public class SearchInRotatedArray {
    public int search(int[] A, int target) {
        // write your code here

        if (A.length == 0 || A == null)
            return -1;
        int start = 0;
        int end = A.length-1;

        while (start+1 < end) {
            int mid = start + (end - start) /2;
            if (A[mid] == target)
                return mid;
            else if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid])
                    end = mid;
                else
                    start = mid;
            }
            else {
                if (A[mid] <= target && target <= A[end])
                    start = mid;
                else
                    end = mid;
            }

        }
        if (A[start] == target)
            return start;
        else if (A[end] == target)
            return end;
        else
            return -1;
    }


}
