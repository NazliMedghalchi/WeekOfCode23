/**
 * Created by Nazli on 2016-10-11.
 */
/**
 * @param A: An integers array.
 * @return: return any of peek positions.
 */
public class FindPeakElement {
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0)
            return -1;
        int start = 0;
        int end = A.length-1;
        int mid = 0;

        while (start + 1 <= end) {
            mid = start + (end - start)/2;

            if (A[mid] > A[mid-1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if (A[mid] < A[mid-1])
                end = mid;
            else if (A[mid] < A[mid+1]) {
                start = mid;
            }
        }

        if (A[start] < A[end] || end == A.length-1)
            return end;
        else
            return start;
    }

}
