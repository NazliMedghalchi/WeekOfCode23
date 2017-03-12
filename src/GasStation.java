/**
 * Created by Nazli on 2016-11-03.
 */
/**
 * Question: http://www.lintcode.com/en/problem/gas-station/
 * Solution src: https://github.com/shawnfan/LintCode/blob/master/Java/Gas%20Station.java
 *
 * **/
public class GasStation {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if ( gas == null || cost == null || gas.length == 0 || cost.length == 0){
            return -1;
        }

        int start = 0;
        int total = 0;
        int sum = 0;
        // travers through all possible starting points
        // at each point if the remaining gas from station i to i+1 is not enough
        // set next station as starting station
        for (int  i = 0; i<cost.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0){
                sum = 0;
                start = i+1;
            }
            total += gas[i] - cost[i];
        }
        // if there's no way to make a loop on stations
        if (total < 0){
            return -1;
        }
        return start;
    }
}
