import java.util.*;

/**
 * Created by Nazli on 2017-01-05.
 */

/**
 * Question Source: http://www.lintcode.com/en/problem/word-ladder/
 * Solution Source: https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73094
 *                  http://www.jiuzhang.com/solutions/word-ladder/
 * */
public class WordLadder {

        /**
         * @param start, a string
         * @param end, a string
         * @param dict, a set of string
         * @return an integer
         */
        public int ladderLength(String start, String end, Set<String> dict) {
            // write your code here
            int len = 0;

            if (dict == null || dict.size() == 0){
                return 0;
            }
            if (start.length() != end.length()){
                return len;
            }
            if (start.length() != end.length()){
                return 0;
            }
            assert(start.length() == end.length());

            if (start.equals(end)){
                return 1;
            }


            dict.add(start);
            dict.add(end);

            HashSet<String> set = new HashSet<String>();
            Queue<String> queue = new LinkedList<String>();

            set.add(start);
            queue.add(start);
            len = 1;
            while(!queue.isEmpty()){
                len++;
                int size = queue.size();
                for (int i=0; i<size; i++){
                    String word = queue.poll();

                    // get next word coming after the word polled from queue [start]
                    // from the dict as "string"

                    for (String string : getNextWord(dict, word)){
                        if (string.equals(end)){
                            return len;
                        }
                        if (set.contains(string)){
                            continue;
                        }
                        set.add(string);
                        queue.add(string);
                    }
                }
            }
            return 0;
        }

        public ArrayList<String> getNextWord(Set<String> dict, String word){
            ArrayList<String> listWords = new ArrayList<String>();

            for (char c = 'a'; c <= 'z'; c++){
                for (int i = 0; i < word.length(); i++){
                    // find first next word by checking characters
                    if (c == word.charAt(i)){
                        continue;
                    }
                    // replace the character c at index i in word (to make nextWord)
                    String nextWord = replace(word, c, i);
                    // now check the list if the next word doesn't exist in the list, add it!
                    if (dict.contains(nextWord)){
                        listWords.add(nextWord);
                    }
                }
            }
            return listWords;
        }

        public String replace(String word, char c, int index){
            char[] charWord = word.toCharArray();
            charWord[index] = c;
            return new String(charWord);

        }

}
