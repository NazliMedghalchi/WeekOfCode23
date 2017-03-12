/**
 * Created by Nazli on 2017-01-11.
 */
/**
 * Question source: http://www.lintcode.com/en/problem/climbing-stairs/
 * Solution source: http://www.jiuzhang.com/solutions/climbing-stairs/
 *
 * */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1){
            return 1;
        }
        // instead of 2D table we have 2 vars
        int last = 1;
        int beforeLast = 1;
        int now = 0;
        for (int i=2; i<=n; i++){
            now = last + beforeLast;
            beforeLast = last;
            last = now;
        }
        return now;
    }
}
