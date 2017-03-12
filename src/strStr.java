/**
 * Created by Nazli on 2016-09-19.
 */
public class strStr {

    class Solution {
        /**
         * Returns a index to the first occurrence of target in source,
         * or -1  if target is not part of source.
         * @param source string to be scanned.
         * @param target string containing the sequence of characters to match.
         */
        public int strStr(String source, String target) {
            //write your code here
            // Algo1 - doesn't help as checking 2 exact same string runs in trouble by loc = 0
            // Hence probably the initiallization has to be -1

//            if (source == null || target == null)
//                return -1;
//
//            char[] sourceCh = source.toCharArray();
//            char[] targetCh = target.toCharArray();
//
//            int loc = 0;
//            int i = 0;
//            int j = 0;
//
//
//            if (sourceCh.length < targetCh.length)
//                return -1;
//            else if (targetCh.length == 0 )
//                return 0;
//
//
//            while (i < sourceCh.length && j < targetCh.length) {
//                if (sourceCh[i] == targetCh[j]) {
//                    if (loc == 0 ) {
//                        loc = i; //starting point found
//                    }
//
//                    i++;
//                    j++;
//                    if (i > sourceCh.length)
//                        return -1;
//                    if (j >= targetCh.length)
//                        return loc;
//
//                }
//                else {
//                    i++;
//                    j = 0;
//                    loc = 0;
//                }
//
//            }
//
//
//            return -1;
//            ===========================================
//            Algo2: from tutorials - check by 2 inner loops

            if (source == null || target == null)
                return -1;
            char[] s = source.toCharArray();
            char[] t = target.toCharArray();
            if (s.length < t.length) {
                return -1;
            }
            else {
                for (int i=0; i<s.length- t.length +1; i++) { // at most there are s.length - t.length +1 iterations are possible
                    int j =0 ;
                    for (j=0; j<t.length; j++){
                        if (s[i+j] != t[j])
                            break;
                    }

                    if (j == t.length)
                        return i;
                }
                return -1;
            }


        }
    }
}
