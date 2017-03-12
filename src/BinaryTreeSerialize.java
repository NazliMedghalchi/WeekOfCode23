/**
 * Created by Nazli on 2016-12-19.
 */


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question: http://www.lintcode.com/en/problem/binary-tree-serialization/
 * Solution Source: http://www.jiuzhang.com/solutions/binary-tree-serialization/
 *                  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * */
public class BinaryTreeSerialize {

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
         * This method will be invoked first, you should design your own algorithm
         * to serialize a binary tree which denote by a root node to a string which
         * can be easily deserialized by your own "deserialize" method later.
         */

//        Serialize Method
        public String serialize(TreeNode root) {
            // write your code here
            String serialize = new String();
            if (root == null){
                return "{}";
            }
            Queue<String> queue = new LinkedList<String>();
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }
// Helper method to serialize a Treenode into a String
        public void buildString( TreeNode root, StringBuilder sb){
            String splitter = ",";
            String NN = "#";
            if (root == null){
                sb.append(NN).append(splitter);
            }
            else{
                // PreOrder
                sb.append(root.val).append(splitter);
                buildString(root.left, sb);
                buildString(root.right, sb);
            }
        }

        /**
         * This method will be invoked second, the argument data is what exactly
         * you serialized at method "serialize", that means the data is not given by
         * system, it's given by your own serialize method. So the format of data is
         * designed by yourself, and deserialize it here as you serialize it in
         * "serialize" method.
         */


//        Deserialize Method
        public TreeNode deserialize(String data) {
            // write your code here
            String splitter = ",";

            Deque<String> deque = new LinkedList<>();
            deque.addAll(Arrays.asList(data.split(splitter)));
            return buildTree(deque);

        }
//      Desrialize helper method that takes a deque (double-end queue) as input
//      checkes if either is empty ({}) or a null value ("#") then return null
//      otherwise build on left and right children
        public TreeNode buildTree(Deque<String> deque){
            String NA = "#";
            String val = deque.remove();

            if ( val.equals(NA) || val.equals("{}") ){
                return null;
            }
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(deque);
                node.right = buildTree(deque);
                return node;
            }

        }

}
