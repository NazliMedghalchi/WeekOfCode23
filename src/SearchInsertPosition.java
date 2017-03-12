/**
 * Created by Nazli on 2016-10-01.
 */
/**
 * param A : an integer sorted array
 * param target :  an integer to be inserted
 * return : an integer
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A.length == 0 || A == null)
            return 0;

        if (A[0] >= target)
            return 0;
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start )/2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] < target) {
                start = mid;
            }
            else if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[start] >= target) return start;
        else if (A[end] >= target) return end;
        else return end+1;
    }

}
