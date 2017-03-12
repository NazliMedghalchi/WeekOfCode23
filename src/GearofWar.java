/**
 * Created by Nazli on 2016-09-12.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GearofWar {
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        int cn = 0;
        while (cn<test){
            int number = scan.nextInt();
            if (number%2 == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

}
