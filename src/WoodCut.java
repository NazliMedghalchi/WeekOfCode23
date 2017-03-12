/**
 * Created by Nazli on 2016-10-04.
 */
/**
 *@param L: Given n pieces of wood with length L[i]
 *@param k: An integer
 *return: The maximum length of the small pieces.
 */
public class WoodCut {

    public int cut(int[] L , int len) {
        int sum = 0;
        for (int i=0; i<L.length; i++) {
            sum += L[i]/len;
        }
        return sum;
    }
    public int woodCut(int[] L, int k) {
        // write your code here

        if (L.length == 0 || L == null) {
            return 0;
        }
        int total =0;
        int max = 0;
        for (int n : L) {
            max = Math.max(max, n);
        }

        int start = 1;
        int end = max;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end -start)/2;
            int n = cut(L, mid);
            if (n >= k)
                start = mid;
            else
                end = mid;
        }

        if (cut(L, end) >= k) {
            return end;
        }
        else if (cut(L, start) >= k)
            return start;
        return 0;
    }

}
