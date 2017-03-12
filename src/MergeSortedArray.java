/**
 * Created by Nazli on 2016-09-29.
 */

/**
 * @param A: sorted integer array A which has m elements,
 *           but size of A is m+n
 * @param B: sorted integer array B which has n elements
 * @return: void
 */

public class MergeSortedArray {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
// Start from end of array A
//        Array of size m+n-1 though it has m elements

        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while (i>=0 && j>=0) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            }
            else
                A[k--] = A[i--];
        }

        while (i>=0)
            A[k--] = A[i--];
        while (j>=0)
            A[k--] = B[j--];

    }

}
