/**
 * Created by Nazli on 2016-11-06.
 */
/**
 * Question: http://www.lintcode.com/en/problem/jump-game/
 * Solution source: http://www.jiuzhang.com/solutions/jump-game/
 *
 * */
public class CanJump {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here

        // Greedy Algorithm
    /*    if (A == null || A.length == 0) return false;

        int far = A[0];
        // boolean flag = false;
        for (int index = 1; index < A.length; index ++) {
            if (index < far && index + A[index] >= far)
                far += A[index];
        }
        return far >= A.length - 1;
    */
        // Dynamic Programming
        boolean[] jump = new boolean[A.length];
        jump[0] = true;
        for (int i = 1; i<A.length; i++){
            for (int j = 0; j < i; j++){
                if (jump[j] == true && (A[j] + j) >= i){
                    jump[i] = true;
                    break;
                }
            }
        }
        return jump[A.length - 1];


    }

}
