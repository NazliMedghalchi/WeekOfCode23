/**
 * Created by Nazli on 2016-10-28.
 */

import java.util.HashSet;

/**
 *@param n: Given a decimal number that is passed in as a string
 *@return: A string
 */
/**
 * Source for solution: http://www.jiuzhang.com/solutions/binary-representation/
 * Question: http://www.lintcode.com/en/problem/binary-representation/#
 *  */


public class BinaryRepresentation {

        // parse the float part
    private String parse(String str){
        double d = Double.parseDouble("0." + str);
        String num = "";
        HashSet<Double> set = new HashSet<Double>();

        while (d > 0) {
            if (num.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            set.add(d);
            d = d * 2;
            if (d >= 1) {
                num = num + "1";
                d = d-1;
            }
            else {
                num = num + "0";
            }
        }
        return num;
    }

    private String parseInteger(String str){
        if (str.equals("0") || str == ""){
            return "0";
        }
        int num = Integer.parseInt(str);
        String result = "";
        while (num != 0){
            result = Integer.toString(num % 2) + result;
            num = num / 2;
        }
        return result;
    }

    public String binaryRepresentation(String n) {
        // write your code here
        if (n.indexOf('.') == -1) {
            parse(n);
        }

        String[] str = n.split("\\.");
        String fl = parse(str[1]);
        if (fl == "ERROR"){
            return fl;
        }
        if (fl == "0" || fl.equals("") ){
            return parseInteger(str[0]);
        }
        return parseInteger(str[0]) + "." + fl;
    }
}

