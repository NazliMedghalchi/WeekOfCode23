/**
 * Created by Nazli on 2016-10-26.
 */

import java.awt.datatransfer.StringSelection;

/**
 *@param  n, m: Two integer
 *@param  i, j: Two bit positions
 *return: An integer
 */
public class UpdateBits {

    int n;
    int m;
    int i;
    int j;

    public UpdateBits(){

    }
    public int updateBits(int n, int m, int i, int j) {
        // write your code here

        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(m);


        int val = s2.length() - j -1;
        if (i + val > s1.length() )
            return 0;

        int d = j;
        StringBuilder sb = new StringBuilder(s1);

        for (int c=i; c+j < s1.length(); c++) {
            char ch = s2.charAt(d++);
            sb.setCharAt(c, ch);
        }

        s1 = sb.toString();
        System.out.println(s1);
        Integer num = Integer.valueOf(s1);
        return num;
    }

    public static void main (String[] args){
        UpdateBits updateBits = new UpdateBits();
        int n = 32;
        int m = 5;
        int i = 2;
        int j = 6;

        System.out.print(updateBits.updateBits(n, m, i, j));
    }
}
