import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nazli on 2017-05-03.
 */

/*
* Question source: http://www.lintcode.com/en/problem/word-search-ii/
* Solution source: http://www.jiuzhang.com/solutions/word-search-ii/
* */
public class WordSearch2 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode {
        boolean isString;
        String s;
        HashMap<Character, TrieNode> submap;
        public TrieNode() {
            isString = false;
            s = "";
            submap = new HashMap<Character, TrieNode>();
        }
    };

    class TrieTree{
        TrieNode root;

        public TrieTree(TrieNode trienode){
            root = trienode;
        }

        public void insert(String s){
            TrieNode currentPointer = root;
            for (int i = 0; i<s.length(); i++){
                if (!currentPointer.submap.containsKey(s.charAt(i))){
                    currentPointer.submap.put(s.charAt(i), new TrieNode());
                }
                currentPointer = currentPointer.submap.get(s.charAt(i));
            }
            currentPointer.s = s;
            currentPointer.isString = true;
        }
    };

    public int[] dirX = {1, 0, -1, 0};
    public int[] dirY = {0, 1, 0, -1};

    public void searchDFS(char[][] board, int x, int y, String str, ArrayList<String> res, TrieNode root){
        if (root.isString == true){
            if (!res.contains(root.s)){
                res.add(root.s);
            }
        }
        if ( x < 0 || x >= board.length || y >= board[0].length || y < 0 || board[x][y] == 0 || root == null)
            return;


        if (root.submap.containsKey(board[x][y])){
            for (int i = 0; i<4; i++){
                char now = board[x][y];
                board[x][y] = 0;
                searchDFS(board, x+dirX[i], y+dirY[i], str, res, root.submap.get(now));
                board[x][y] = now;
            }
        }
    }
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();

        TrieTree tree = new TrieTree(new TrieNode());

        for(String w : words){
            tree.insert(w);
        }

        int row = board.length;
        int col = board[0].length;

        String str = "";
        for (int i = 0; i< row; i++) {
            for (int j = 0; j < col; j++){
                searchDFS(board, i, j, str, res, tree.root);
            }
        }
        return res;
    }
}
