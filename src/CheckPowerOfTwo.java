/**
 * Created by Nazli on 2016-10-13.
 */
   /*
         * @param n: An integer
         * @return: True or false
         */
public class CheckPowerOfTwo {
  public boolean checkPowerOf2(int n) {
        // write your code here

        if (n == 0 )
            return false;
        if (n <= 0)
            return false;
        else {
            boolean res = (n & (n-1)) == 0 ? true : false;
            return res;
        }

    }
};

