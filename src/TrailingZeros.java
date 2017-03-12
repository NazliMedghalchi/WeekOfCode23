/**
 * Created by Nazli on 2016-10-14.
 */
    /*
         * param n: As desciption
         * return: An integer, denote the number of trailing zeros in n!
         */
public class TrailingZeros {
    public long trailingZeros(long n) {
        // write your code here
        // if (n == 0)
        //     return n;
        long ans = 0;
        while (n != 0) {
            ans += n/5;
            n  /= 5;
        }
        return ans;
    }
};


