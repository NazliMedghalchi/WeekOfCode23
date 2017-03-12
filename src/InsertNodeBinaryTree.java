/**
 * Created by Nazli on 2016-11-30.
 */
public class InsertNodeBinaryTree {
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
         * @param node: insert this node into the binary search tree
         * @return: The root of the new binary search tree.
     */


        /******* Version 1 No recursion ******/

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    /*    if (root == null){
            root = node;
            return root;
        }
        TreeNode temp = root;
        TreeNode last = null;
        while (temp != null){
            last = temp;
            if (temp.val > node.val){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        if (last.val > node.val){
            last.left = node;
        }
        else {
            last.right = node;
        }
        return root;
        */

    /****** Versionn 2 Recursion *****/
    if (root == null){
        return node;
    }
    if (root.val > node.val){
        root.left = insertNode(root.left, node);
    }
    else
        root.right = insertNode(root.right, node);
    return root;
    }
}
