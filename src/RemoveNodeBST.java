/**
 * Created by Nazli on 2016-12-19.
 */

/**
 * Question: http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
 * Solution source: https://www.youtube.com/watch?v=gcULXE7ViZw
 *                  http://www.jiuzhang.com/solutions/remove-node-in-binary-search-tree/
 *                  https://leetcode.com/problems/delete-node-in-a-bst/
 * */
public class RemoveNodeBST {

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
         * @param value: Remove the node with given value.
         * @return: The root of the binary search tree after removal.
         */

     /*
     Case 1: where target node has no children (leaf node)
     Case 2: where target node has only one child either left or right
     Case 3: where target node has two children both left and right
     Note: that we want to reduce case 3 to 2
     */


        //  Method 1:
        // ******Remove Node
        public TreeNode removeNode(TreeNode root, int value) {
            // write your code here


            // method 3: https://leetcode.com/problems/delete-node-in-a-bst/

            if (root == null) {
                return null;
            }
            TreeNode dummy = new TreeNode(0);
            dummy.left = root;

            TreeNode parent = findNode(dummy, root, value);
            TreeNode node;

            // if it has only one left child (case2)
            if (parent.left != null && parent.left.val == value){
                node = parent.left;
                remove(parent, node);
            }
            else if (parent.right != null && parent.right.val == value){
                node = parent.right;
                remove(parent, node);
            }
            // if it has only one right child (case2)
            // else {
            //     node = dummy.left;
            // }

            // remove(parent, node);
            // return the root for entire tree
            return dummy.left;
        }

    // ******find the position of the node (find the node to remove)
    public TreeNode findNode (TreeNode parent, TreeNode root, int value){
        // how to find a node? where to look for the node?
        if (root == null) {
            return parent;
        }
        if (root.val == value) {
            return parent;
        }
        if (root.val > value){
            return findNode (root, root.left, value);
        }
        else{
            return findNode(root, root.right, value);
        }

    }

    //  ******* Delete the node that you found from tree
    public void remove(TreeNode parent, TreeNode node){
        // how to remove the position?
        if (node.right == null){
            if (parent.left == node){
                parent.left = node.left;
            }
            else {
                parent.right = node.left;
            }
        }

        // find node position -- here we find it with 2 children (case3)
        else {
            TreeNode temp = node.right;
            TreeNode pre = node;

            while (temp.left != null){
                // find the deepest [left] child to create case2
                pre = temp;
                temp = temp.left;
            }

            if (pre.left == temp){
                pre.left = temp.right;
            }
            else {
                pre.right = temp.right;
            }

            // check the very first parent as in case2 with the
            if (parent.left == node){
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            temp.left = node.left;
            temp.right = node.right;
        }

    }

    // Method 3 deleteNode function

        // Method 2

       /* if (root == null) {
            return null;
        }
        if (root.val > value){
            return removeNode(root.left, value);
        }
        else if (root.val < value){
            return removeNode(root.right, value);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            else {
                TreeNode node = findMin(root.right);
                root.val = node.val;
                root.right = removeNode(root.right, root.val);
            }
            return root;
        }
    }

    // find minimum child
    public TreeNode findMin(TreeNode rightNode) {
        while (rightNode.left != null){
            rightNode = rightNode.left;
        }
        return rightNode;
    }*/

        //  find tree height
   /* public int findHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int countL = 0;
        int countR = 0;
        int left,right;

        if (root.left != null){
            countL++;
            left = findHeight(root.left);
        }
        if (root.right != null){
            countR++;
            right = findHeight(root.right);
        }
        return Math.max(left, right);
    }*/


}
