/**
 * Created by Nazli on 2016-11-06.
 */
/**
 * Question: http://www.lintcode.com/en/problem/delete-digits/
 * Solution sourc: http://www.jiuzhang.com/solutions/delete-digits/
 *
 *
 * */
public class DeleteDigit {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0){
            return "";
        }
        int r = A.length() - k;

        StringBuffer sb = new StringBuffer(A);

        for (int i = 0; i < k; i++){
            int j = 0;
            for (j = 0; j+1 < sb.length() &&
                    sb.charAt(j) <= sb.charAt(j+1); j++){}
            sb.delete(j, j+1);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
