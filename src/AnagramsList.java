/**
 * Created by Nazli on 2016-09-26.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param strs: A list of strings
 * @return: A list of strings
 */

public class AnagramsList {
    public int checkAnagram(String s1){

        if (s1 == null )
            return 0;
        char[] sch1 = s1.toCharArray();

        int h = 0;
        int[] hashList = new int[sch1.length];
        for (char ch : sch1) {
            h = h + hashList[ch - 'a']++;
        }
        return h;
        // for (char c : sch1) {
        //     if (hash.containsKey(c)) {
        //         int value = (Integer) hash.get(c);
        //         hash.put(c, ++value);
        //     }
        //     else
        //          hash.put(c, 1);
        // }
        // for (char c :sch2){
        //     if (!hash.containsKey(c))
        //         return false;
        //     else {
        //         int value = (Integer)hash.get(c);
        //         hash.put(c, --value);
        //         if (value < 0)
        //             return false;
        //     }

        // }
        // return true;
    }

//    Define a hashCode method (here it uses 2 large prime numbers to create hashcode)
//    src: http://www.jiuzhang.com/solutions/anagrams/
    public int getHash(int[] h) {
        int H =0;
        int a = 378551;
        int b = 63689;
        for (int i : h) {
            H = H * a + i;
            a = a * b;
        }
        return H;
    }
    public List<String> anagrams(String[] strs) {
        // write your code here
        // need a hash map to check anagrams by checking ascii code stored in String format
        // Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        // The array list to store returning list of all anagrams
        ArrayList<String> anagramList = new ArrayList<String>();

        if (strs == null || strs.length == 0)
            return anagramList;
        int res = 0;
        int h = 0;

        for (int i=0; i<strs.length; i++){
            int[] hashArray = new int[26];

            for (int j=0; j<strs[i].length(); j++) {
                hashArray[strs[i].charAt(j) - 'a']++;
            }
            //  String s = String.valueOf(h);
            int s = getHash(hashArray);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }

        for(ArrayList<String> temp : map.values())
            if (temp.size() > 1)
                anagramList.addAll(temp);
        return anagramList;
    }

}
