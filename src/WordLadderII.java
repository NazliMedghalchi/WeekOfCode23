import java.util.*;

/**
 * Created by Nazli on 2017-01-10.
 */

/**
 * Question source: http://www.lintcode.com/en/problem/word-ladder-ii/
 * Solution source: https://leetcode.com/problems/word-ladder-ii/
 * */
public class WordLadderII {
        /**
         * @param start, a string
         * @param end, a string
         * @param dict, a set of string
         * @return a list of lists of string
         */
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            // write your code here

            List<List<String>> list = new ArrayList<List<String>>();
            Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
            Map<String, Integer> distance = new HashMap<String, Integer>();
            List<String> solution = new ArrayList<String>();

            if (start.length() != end.length()){
                return list;
            }

            dict.add(end);
            bfs (start, end, dict, neighbors, distance);
            dfs (start, end, dict, neighbors, distance, list, solution);
            return list;
        }

        public void dfs (String current, String end, Set<String> dict, Map<String, List<String>> neighbors, Map<String, Integer> distance, List<List<String>> list, List<String> solution){

            solution.add(current);
            if (end.equals(current)){
                list.add(new ArrayList<String>(solution));
            }
            for (String node : neighbors.get(current)){
                if (distance.get(node) == distance.get(current) + 1){
                    dfs(node, end, dict, neighbors, distance, list, solution);
                }
            }
            solution.remove(solution.size() -1 );
        }

        public void bfs (String start, String end, Set<String> dict, Map<String, List<String>> neighbors,
                         Map<String, Integer> distance){

            for (String str : dict){
                neighbors.put(str, new ArrayList<String>());
            }
            Queue<String> queue = new LinkedList<String>();
            queue.offer(start);
            distance.put(start, 0);

            while(!queue.isEmpty()){
                int qSize = queue.size();
                boolean found = false;

                for (int i = 0; i<qSize; i++){
                    String current = queue.poll();
                    int currentDist = distance.get(current);
                    List<String> nodeNeighbor = getNeighbors(current, dict);

                    for (String node : nodeNeighbor){
                        neighbors.get(current).add(node);
                        if (!distance.containsKey(node)){
                            distance.put(node, currentDist + 1);
                            queue.offer(node);
                            if (end.equals(node)){
                                found = true;
                            }

                        }
                    }
                    if (found == true){
                        break;
                    }
                }
            }
        } // end of bfs

        public List<String> getNeighbors(String current, Set<String> dict){
            ArrayList<String> result = new ArrayList<String>();

            char[] charCurrent = current.toCharArray();
            for (int i = 0; i < charCurrent.length; i++){
                char old_char;
                for (char ch ='a'; ch <= 'z'; ch++){
                    if (charCurrent[i] == ch){
                        // if the character is the same continue till find the difference
                        continue;
                    }
                    old_char = charCurrent[i];
                    charCurrent[i] = ch;
                    if (dict.contains(String.valueOf(charCurrent))){
                        result.add(String.valueOf(charCurrent));
                    }
                    charCurrent[i] = old_char;
                }
            }
            return result;
        } // end of getNeighbors


}
