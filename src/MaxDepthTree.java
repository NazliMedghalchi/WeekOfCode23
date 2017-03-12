/**
 * Created by Nazli on 2016-11-18.
 */
/**
 * Question: http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
 * Solution source: http://www.jiuzhang.com/solutions/maximum-depth-of-binary-tree/
 *
 *
 * */
public class MaxDepthTree {
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
    public class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer.
         */
        private int depth;
        private void findDepth(TreeNode root, int curLen){
            if (root == null){
                return;
            }

            if (depth < curLen){
                depth = curLen;
            }
            findDepth(root.left, curLen+1);
            findDepth(root.right, curLen+1);

        }
        public int maxDepth(TreeNode root) {
            // write your code here

            depth = 0;
            findDepth(root, 1);
            return depth;
        }
    }
}
