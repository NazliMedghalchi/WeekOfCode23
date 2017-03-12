import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazli on 2017-01-03.
 */

/**
 * Question source: http://www.lintcode.com/en/problem/combinations/
 * Solution source: http://www.jiuzhang.com/solutions/combinations/
 *
 * */
public class Combine {

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<Integer> num = new ArrayList<Integer>();
        List< List<Integer> > numSet = new ArrayList<List<Integer>>();
        if (k > n){
            return null;
        }

        if (k == n){
            for (int i = 1; i <= n; i++){
                num.add(i);
            }
            numSet.add(num);
            return numSet;
        }

        if (k == 0 || k == 1){
            for (int i = 1; i <= n; i++){
                List<Integer> number = new ArrayList<Integer>();
                number.add(i);
                numSet.add(number);
            }

            return numSet;
        }
        int start = 1;
        combination(num, numSet, n, k, start);
        return numSet;

    }

    public void combination(List<Integer> num, List<List<Integer>>
            numSet, int n, int k, int start){

        if (num.size() == k){
            numSet.add(new ArrayList(num));
            return;
        }
        for (int i = start; i <= n; i++){
            num.add(i);
            combination(num, numSet, n, k, i+1);
            num.remove(num.size() - 1);
        }
    }
}
