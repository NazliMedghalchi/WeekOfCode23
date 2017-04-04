/**
 * Created by Nazli on 2017-03-12.
 */
import java.util.Set;

/*
* Question Source: http://www.lintcode.com/en/problem/word-break/
* solution soource: http://www.jiuzhang.com/solutions/word-break/
* */
public class WordBreak {

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */

    public int maxLength(Set<String> dict){
        int maxlength = 0;
        for (String word : dict){
            maxlength = Math.max(maxlength, word.length());
        }
        return maxlength;
    }


    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (dict == null || s.length() == 0 || s == null)
            return true;

        int ls = s.length();
        boolean[] segmented = new boolean[ls + 1];
        int maxlength = maxLength(dict);

        segmented[0] = true;
        for (int i = 1; i <= ls; i++){
            segmented[i] = false;
            for (int segmentLength = 1; segmentLength <= maxlength && segmentLength <= i; segmentLength++) {

                if (!segmented[i - segmentLength]) continue;
                String lookup = s.substring(i - segmentLength, i);
                if (dict.contains(lookup)){
                    segmented[i] = true;
                    break;
                }
            }
        }
        return segmented[s.length()];

    }
}
