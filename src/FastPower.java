/**
 * Created by Nazli on 2016-10-28.
 */
/*
 * @param a, b, n: 32bit integers
 * @return: An integer
 */
/*
* Chapter4 from lintcode: http://www.lintcode.com/en/ladder/2/
* Source: http://www.jiuzhang.com/solutions/fast-power/
*
*
* */
public class FastPower {

    public int fastPower(int a, int b, int n) {
        // write your code here
        if (n == 0){
            return 1 % b;
        }

        if (n == 1) {
            return a % b;
        }

        long ans = fastPower(a, b, n / 2);
        ans = (ans * ans) % b;
        if (n % 2 == 1){
            ans = (ans*a) % b;
        }
        return (int) ans;
    }
};
