/**
 * Created by Nazli on 2016-10-13.
 */
/**
 *@param A : an integer sorted array
 *@param target :  an integer to be inserted
 *return : a list of length 2, [index1, index2]
 */
public class SearchForARange {


    public int[] searchRange(int[] A, int target) {
        // write your code here
        if (A.length == 0 || A == null)
            return new int[]{-1, -1};
        int start = 0;
        int end = A.length -1 ;
        int[] res = new int[2];

        // search each left and right separately for the range
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] == target) {
                end = mid;
            }
            else if (A[mid] < target)
                start = mid;
            else if(A[mid] > target)
                end = mid;
        }
        if (A[start] == target)
            res[0] = start;
        else if (A[end] == target)
            res[0] = end;
        else {
            res[0] = res[1] = -1;
            return res;
        }

        start = 0;
        end = A.length-1;

        while (start +1 < end) {
            int mid = start + (end - start)/2;
            if (A[mid] == target)
                start = mid;
            else if (A[mid] < target)
                start = mid;
            else
                end = mid;
        }

        if (A[end] == target) {
            res[1] = end;
        }
        else if (A[start] == target)
            res[1] = start;
        else {
            res[0] = res[1] = -1;
            return res;
        }

        return res;
    }


}
