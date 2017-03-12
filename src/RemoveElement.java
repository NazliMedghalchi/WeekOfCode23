/**
 * Created by Nazli on 2016-09-27.
 */

/**
 *@param A: A list of integers
 *@param elem: An integer
 *@return: The new length after remove
 */

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        // write your code here
        int count = 0;
        int index = A.length-1;
        int i=0;
        while (i <= index) {
            if (A[i] == elem) {
                A[i] = A[index];
                index--;
            }
            else {
                i++;
            }

        }
        return i;
    }


}
