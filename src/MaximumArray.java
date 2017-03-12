/**
 * Created by Nazli on 2016-10-24.
 */
public class MaximumArray {

    int[] A;
    int low;
    int high;
    int max_sum;

    public MaximumArray(int[] A, int low, int high,  int max_sum){

        for (int i=0; i<A.length; i++)
            this.A[i] = A[i];
        this.low = low;
        this.high = high;
        this.max_sum = max_sum;
    }
    public MaximumArray findMaximum(int[] A, int low, int high){


        int max_sum = 0;

        MaximumArray maximumArray = new MaximumArray(A, low, high, max_sum);
        if (high == low) {
            return maximumArray;
        }
        else {
            int mid = (high + low) /2;
            MaximumArray left_max = maximumArray.findMaximum(A, low, mid);
            MaximumArray right_max = maximumArray.findMaximum(A, mid+1, high);
            MaximumArray cross_max = maximumArray.findMaximum(A, low, high);
            if (left_max.max_sum >= cross_max.max_sum && left_max.max_sum >= right_max.max_sum) {
                return left_max;
            }
            else if (right_max.max_sum >= left_max.max_sum && right_max.max_sum >= cross_max.max_sum) {
                return right_max;
            }
            else
                return cross_max;
        }
    }

    public static void main (String[] args){

        int[] A = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int max_sum = 0;
        MaximumArray max_array = new MaximumArray(A, 0, A.length-1, max_sum);
        max_array.findMaximum(A, 0, A.length-1);
        System.out.println(max_array.max_sum);
    }
}
