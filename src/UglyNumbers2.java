import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Nazli on 2017-04-16.
 */
/*
* Question source: http://www.lintcode.com/en/problem/ugly-number-ii/
* Solution source: http://www.jiuzhang.com/solutions/ugly-number-ii/
* */
public class UglyNumbers2 {

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> queue = new PriorityQueue<Long>();
        HashSet<Long> hashset = new HashSet<Long>();

        Long[] primenums = new Long[3];
        primenums[0] = Long.valueOf(2);
        primenums[1] = Long.valueOf(3);
        primenums[2] = Long.valueOf(5);

        for (int i = 0; i<3 ; i++){
            queue.add(primenums[i]);
            hashset.add(primenums[i]);
        }

        Long number = Long.valueOf(1);
        for (int i = 1; i<n; i++){
            number = queue.poll();
            for (int j = 0; j < 3; j++){
                if (!hashset.contains(number * primenums[j])){
                    queue.add(number * primenums[j]);
                    hashset.add(number * primenums[j]);
                }
            }
        }
        return number.intValue();

    }

}
