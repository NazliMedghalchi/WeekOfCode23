import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nazli on 2016-11-03.
 */
public class LargestNumber {
        /**
         *@param num: A list of non negative integers
         *@return: A string
         */

    public String largestNumber(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return "";
        }

        String[] st = new String[num.length];
        for (int i = 0; i < st.length; i++){
            st[i] = Integer.toString(num[i]);
        }

        Arrays.sort(st, new Comparator<String>() {

            public int compare(String s1, String s2){
                String first = s2 + s1;
                String second = s1 + s2;
                return first.compareTo(second);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length; i++) {
            sb.append(st[i]);
        }

        String str = sb.toString();
        int index = 0;
        while (index < str.length() && str.charAt(index) == '0'){
            index++;
        }
        if (index == str.length()){
            return "0";
        }
        return str.substring(index);
    }
}
