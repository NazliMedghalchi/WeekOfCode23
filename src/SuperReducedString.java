/**
 * Created by Nazli on 2016-09-22.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class SuperReducedString {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String example = scan.next();
        //char[] s = example.toCharArray();
        // while there is no duplicaiton continue on reducing the similar letters
        int i=0;

        StringBuilder s1 = new StringBuilder();
        while (example.charAt(i) - example.charAt(i+1) == 0 && i+1<example.length()) {
            String s2 = example.substring(i+2);
            s1 = s1.append(s2);
            if (s1 == null)
                System.out.println("Empty String");
            i++;
        }
        System.out.println(s1);
    }
}
