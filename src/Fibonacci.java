/**
 * Created by Nazli on 2016-11-17.
 */
/**
 * Question: http://www.lintcode.com/en/problem/fibonacci/
 * Solution source: https://github.com/shawnfan/LintCode/blob/master/Java/Fibonacci.java
 *
 * */
public class Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        // recursivef -- time limit exceeds
    /* if (n <= 1){
        return 0;
    }
    else if (n == 2){
        return 1;
    }
    // recursion
    return fibonacci(n-1) + fibonacci(n-2);
    */
        // Non-recursive -- no running time issue
        if (n <= 1){
            return 0;
        }
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n-1];
    }

}
