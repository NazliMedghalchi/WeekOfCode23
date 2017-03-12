/**
 * Created by Nazli on 2016-10-01.
 */

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
public class Sqrt {

    public int sqrt(int x) {
        // write your code here

        long s = 1; //start
        long e = x; //end

        if (x == 0 || x == 1)
            return x;

        long mid =  s + ((e-s)/2);
        while (s <= e) {
            if (mid * mid < x) {
                s = mid + 1;
            }
            else if (mid * mid > x)
                e = mid - 1;
            else
                return (int) mid;
            mid = s+ ((e - s)/2);
        }
        if (mid * mid <= x)
            return (int) s;
        else
            return (int) e;
    }

}
