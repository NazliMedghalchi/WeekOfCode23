/**
 * Created by Nazli on 2016-10-13.
 */
/**
 *@param a, b: Two integer
 *return: An integer
 */
public class FlipBits {
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        if (a == b)
            return 0;
        int x = a^b;
        int count = 32;
        int num = 0;

        while (count > 0) {
            num += x & 1;
            x = x >> 1;
            count--;

        }
        return num;
    }
};