/**
 * Created by Nazli on 2016-09-29.
 */

import java.util.ArrayList;

/**
 * @param A: Given an integers array A
 * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
 */
public class ProductOfArrExcludingItself {

    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code

        ArrayList<Long> B = new ArrayList<Long>();

        int size = A.size();
        long[] tempArr = new long[size];
        int i;
        // int now = 1; // index to new value from A
        // int temp = 1; // multipy previous now
        // tempArr[size-1] = A.get(size-1);
        // for ( i=size-2; i>=0 ; i++) {
        //     tempArr[i] = (Long) A.get(i);
        //     tempArr[i] =  tempArr[i] * (Long) A.get(i+1);
        // }

        // for (int j=0; j<size; j++) {
        //     now = temp;
        //     if (j+1 < size) {
        //         B.add(tempArr[j+1] * now);
        //     }
        //     else {
        //         B.add(now);
        //     }
        //     now = A.get[j];
        //     temp = now * temp;
        // }
        // return B;

        for (i=0; i<size; i++){
            int j=0;
            long val = 1;
            while (j < size) {
                if (i != j) {
                    val *= A.get(j);
                }
                j++;
            }
            B.add(val);
        }
        return B;

    }

}
