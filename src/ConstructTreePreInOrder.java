/**
 * Created by Nazli on 2016-12-17.
 */

/***
 * Question: http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Solution source: http://www.jiuzhang.com/solutions/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * */

public class ConstructTreePreInOrder {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
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


        /**
         *@param preorder : A list of integers that preorder traversal of a tree
         *@param inorder : A list of integers that inorder traversal of a tree
         *@return : Root of a tree
         */

        public int findPosition (int[] array, int start, int end, int key){
            for (int i = start; i <= end; i++){
                if (array[i] == key){
                    return i;
                }
            }
            return -1;
        }
        public TreeNode makeTree(int[] inorder, int startIn, int endIn, int[] preorder, int startPre, int endPre){
            if (startIn > endIn){
                return null;
            }
            TreeNode root = new TreeNode(preorder[startPre]);
            int position = findPosition(inorder, startIn, endIn, preorder[startPre]);

            root.left = makeTree(inorder, startIn, position-1, preorder, startPre+1, startPre + position - startIn);
            root.right = makeTree(inorder, position + 1, endIn, preorder, position - endIn + endPre +1, endPre);
            return root;

        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // write your code here
            if ( preorder.length != inorder.length){
                return null;
            }
            return makeTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
        }
}
