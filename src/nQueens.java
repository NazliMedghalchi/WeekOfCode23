import java.util.ArrayList;

/**
 * Created by Nazli on 2017-01-08.
 */
/**
 * Question source: http://www.lintcode.com/en/problem/n-queens/
 * Solution source: http://www.jiuzhang.com/solutions/n-queens/
 *                  https://developers.google.com/optimization/puzzles/queens
 *                  https://leetcode.com/problems/n-queens/
 *                  http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 *
 * */

/**
 * NOTE:
 * For the solution think of the square around any queen so upper and lower diagonal on both sides
 * are not valid to place new queen on
 *
 * */
public class nQueens {
        /**
         * Get all distinct N-Queen solutions
         * @param n: The number of queens
         * @return: All distinct solutions
         * For example, A string '...Q' shows a queen on forth position
         */
        ArrayList<ArrayList<String>> solveNQueens(int n) {
            // write your code here
            // board: stores all solutions
            ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();

            if (n <= 0){
                return board;
            }
            // new ArrayList<Integer>() as "col" stores all valid column indeces for each row
            search(board, new ArrayList<Integer>(), n);
            return board;
        }

        // private boolean isValid (ArrayList<String> board, int row, int col){
        // int i, j;
        // for (i = 0; i<= row; i++){
        //     if (board[i][col] == "Q"){
        //         return false;
        //     }
        // }
        // for (j = 0; j <= col; j++){
        //     if (board[row][col] == "Q"){
        //         return false;
        //     }
        // }
        // for (i = row, j = 0; i <= row && j >= col; i++, j--){
        //     if (board[i][j] == "Q"){
        //         return false;
        //     }
        // }

        private boolean isValid (ArrayList<Integer> col, int column){
            int rows = col.size();
            // traverse on rows (index = rowIndex)
            for (int index = 0; index < col.size(); index++){
            /* Check this row on left side */
                if (column == col.get(index)) {
                    return false;
                }

            /* if rowIndex + colIndex == rows (n) + column which is
            Check upper diagonal on right side */
                if (index + col.get(index) == rows + column){
                    return false;
                }
            /* subtract the row column indeces, if it's as number of MaxRows - the column
             it is not the solution */
            /* lower diagonal on right side*/
                if (index - col.get(index) == rows - column){
                    return false;
                }
            }
            return true;
        }


        private void search (ArrayList<ArrayList<String>> board, ArrayList<Integer> colsList, int n){

            if (colsList.size() == n){
                board.add(drawBoard(colsList));
                return;
            }
            for (int colsIndex = 0; colsIndex < n; colsIndex++){
                if (!isValid(colsList, colsIndex)){
                    continue;
                }
                colsList.add(colsIndex);
                search(board, colsList, n);
                colsList.remove(colsList.size() - 1);
            }
        }

        private ArrayList<String> drawBoard (ArrayList<Integer> cols) {
            ArrayList<String> board = new ArrayList<String>();

            for (int c = 0; c < cols.size(); c++){
                StringBuilder sb = new StringBuilder();
                for (int cl = 0; cl < cols.size(); cl++){
                    sb.append(cl == cols.get(c) ? 'Q' : '.');
                }
                board.add(sb.toString());
            }

            return board;
        }

};
