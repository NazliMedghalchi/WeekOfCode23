import java.util.PriorityQueue;
import  java.util.*;


/**
 * Created by Nazli on 2017-05-08.
 */
/*
* Question Source: http://www.lintcode.com/en/problem/data-stream-median/
* Solution source: http://www.jiuzhang.com/solutions/data-stream-median/
*
* */
public class DataStreamMedian {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private PriorityQueue<Integer> minqueue; // holding # of right heap
    private PriorityQueue<Integer> maxqueue; // holding # of left heap
    int numElements = 0;

    public int[] medianII(int[] nums) {
        // write your code here
        int[] res = new int[nums.length];

        //if (nums == null || nums.length == 0) return res;
        //int median = 0;

        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer left, Integer right){
                return right.compareTo(left);
            }
        };
        maxqueue = new PriorityQueue<Integer>(nums.length, cmp); // left queue
        minqueue = new PriorityQueue<Integer>(nums.length); //right queue

        for (int j = 0; j < nums.length; j++){
            addElement(nums[j]);
            res[j] = getMedian();
        }
        return res;
    }

    int getMedian(){
        return maxqueue.peek();
    }

    void addElement(int num){
        // even number of elements
        maxqueue.add(num);
        // if number of elements is even then
        // check if minqueue (right heap) is empty then just increase the number of elements.
        if (numElements % 2 == 0) {
            if (minqueue.isEmpty()){
                numElements++;
                return;
            }
            else if (maxqueue.peek() > minqueue.peek()){
                int maxqueuePeek = maxqueue.poll();
                int minqueuePeek = minqueue.poll();
                maxqueue.add(minqueuePeek);
                minqueue.add(maxqueuePeek);
            }
        }
        else{
            minqueue.add(maxqueue.poll());
        }

        numElements++;
    }

}
