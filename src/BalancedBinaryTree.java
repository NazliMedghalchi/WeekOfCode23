/**
 * Created by Nazli on 2016-11-18.
 */

/**
 * Question: http://www.lintcode.com/en/problem/balanced-binary-tree/
 * Solution source: http://www.jiuzhang.com/solutions/balanced-binary-tree/
 *
 * */
public class BalancedBinaryTree {
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
    class resultType{
        boolean isBalance;
        int maxDepth;
        public resultType(boolean isBalance, int maxDepth){
            this.isBalance = isBalance;
            this.maxDepth = maxDepth;
        }
    }
        /**
         * @param root: The root of binary tree.
         * @return: True if this Binary tree is Balanced, or false.
         */
        // private void checkBalance(TreeNode node, length){
        //     if (node == null){
        //         return;
        //     }
        //     int length = 0;
        // }

// version1: using helper function and class

        public boolean isBalanced(TreeNode root) {
            // write your code here

            // return helper(root).isBalance;
            return maxDepth(root) != -1;
        }
    /*
    public resultType helper(TreeNode root){
        if (root == null){
            return new resultType(true, 0);
        }
        resultType left  = helper(root.left);
        resultType right = helper(root.right);

        if (!left.isBalance || !right.isBalance){
            return new resultType(false, -1);
        }
        if (Math.abs(left.maxDepth - right.maxDepth) > 1){
            return new resultType(false, -1);
        }
        return new resultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
        */

        //  version2: No extra class
        public int maxDepth(TreeNode node){
            if (node == null){
                return 0;
            }
            int left = maxDepth(node.left);
            int right = maxDepth(node.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1){
                return -1;
            }
            return Math.max(left, right) + 1;
        }
}
