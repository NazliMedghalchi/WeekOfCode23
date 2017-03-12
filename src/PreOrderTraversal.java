/**
 * Created by Nazli on 2016-11-30.
 */

import java.util.ArrayList;

/**
 * Question: http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 * SOlution source: http://www.jiuzhang.com/solutions/binary-tree-preorder-traversal/
 *
 *
 * */
public class PreOrderTraversal {
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
         * @param root: The root of binary tree.
         * @return: Preorder in ArrayList which contains node values.
         */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> array = new ArrayList<Integer>();
        if (root == null) {
            return array;
        }

        array.add(root.val);
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        array.addAll(left);
        array.addAll(right);
        return array;
    }
}
