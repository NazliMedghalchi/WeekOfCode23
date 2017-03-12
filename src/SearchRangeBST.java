/**
 * Created by Nazli on 2016-12-18.
 */

import java.util.ArrayList;

/**
 * Question: http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 * Solution source: http://www.jiuzhang.com/solutions/search-range-in-binary-search-tree/
 * */
public class SearchRangeBST {

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */

    public ArrayList<Integer> ans;
    public void searchHelper(TreeNode node, int k1, int k2){
        if (node == null){
            return;
        }
        int temp = node.val;
        if (temp > k1) {
            searchHelper(node.left, k1, k2);
        }
        if (temp >= k1 && temp <= k2){
            ans.add(temp);
        }
        if (temp < k2) {
            searchHelper(node.right, k1, k2);
        }
    }
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here


        ans = new ArrayList<Integer>();
        if (k1 > k2){
            return ans;
        }
        if (root == null){
            return ans;
        }
        searchHelper(root, k1, k2);
        return ans;
    }
}
