/**
 * Created by Nazli on 2016-09-26.
 */
/**
 * @param A, B: Two string.
 * @return: the length of the longest common substring.
 */
public class longestCommonSubstring {


    public int longestCommonSubstring(String A, String B) {
        // write your code here
        char[] Achar = A.toCharArray();
        char[] Bchar = B.toCharArray();
        int[] l = new int[A.length()];
        int res = 0;

        for (int i=0; i<Achar.length; i++) {
            for (int j=0; j<Bchar.length; j++) {
                if (Achar[i] == Bchar[j]) {
                    int k = 0; // counter to follow the substring by length
                    while (i+k < Achar.length && j+k<Bchar.length && Achar[i+k] ==  Bchar[j+k]) {
                        k++;
                        // if the found new k larger than max length then swap
                        if (k > res){
                            res = k;
                        }
                    }
                }
            }
        }
        return res;
    }

}
