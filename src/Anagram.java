import java.util.HashMap;


public class Anagram {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */


    public boolean anagram(String s, String t) {
        // write your code here
        // useDelimiter(" \" a-z \" ")
        // Scanner scan = new Scanner(System.in);
        // String first = scan.next();
        // char[] fChar = first.toCharArray();
        // String second =  scan.next();
        //s.replaceAll("\\s+","");
        //t.replaceAll("\\s+","");

        char[] sChar = s.toCharArray();
        char[] fChar = t.toCharArray();

        if (s.length() != t.length()) return false;

        HashMap hash = new HashMap();

        for (char c : sChar) {
            if (!hash.containsKey(c))
                hash.put(c, 1);
            else {
                int value = (Integer) hash.get(c);
                hash.put(c, ++value);
            }

        }
        for (char c2 : fChar) {
            if (!hash.containsKey(c2)) {
                return false;
            }
            else {
                int value = (Integer) hash.get(c2);
                hash.put(c2, --value);
                if (value < 0) return false;
            }

        }
        return true;
    }
};