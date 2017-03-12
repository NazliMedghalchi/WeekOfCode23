import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nazli on 2016-12-18.
 */

/**
 * Question: http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 * Solution source: http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
 * */
public class BinaryTreeLevelOrderTraversal {

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
     * @return: Level order a list of lists of integer
     */

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        //ArrayList ans = new ArrayList();
        if (root == null){
            return ans;
        }
        // BFS method
        Queue<TreeNode> levelNode = new LinkedList<TreeNode>();
        levelNode.offer(root);

        while(!levelNode.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = levelNode.size();

            for (int i = 0; i < size; i++){
                TreeNode head = levelNode.poll();
                level.add(head.val);
                if (head.left != null){
                    levelNode.offer(head.left);
                }
                if (head.right != null){
                    levelNode.offer(head.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

}
