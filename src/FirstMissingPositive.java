/**
 * Created by Nazli on 2016-09-29.
 */
/**
 * @param A: an array of integers
 * @return: an integer
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A.length == 0 || A == null)
            return 1;

        int val = A.length;
        // sort the array
        // the exception is if the value of A is greater than n means it outof boundry
        // duplicates don't need swap

        for (int i=0; i<A.length; i++) {
            // Fist sort the array
            // missing value is considered where i != A[i] or A[i] != A[A[i]]

            while (A[i] > 0 && A[i] <= A.length && A[i] != i+1) {
                // swap values
                int t = A[A[i] - 1];
                if (t == A[i] ) // check duplicates
                    break;
                A[A[i] -1] = A[i];
                A[i] = t;
            }
        }

        for (int j=0; j<A.length; j++) {
            if (A[j] != j+1)
                return j+1;
        }
        return val+1;
    }

}
