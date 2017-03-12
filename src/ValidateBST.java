/**
 * Created by Nazli on 2016-12-17.
 */

/***
 * Question: http://www.lintcode.com/en/problem/validate-binary-search-tree/
 * Solution source: http://www.jiuzhang.com/solutions/validate-binary-search-tree/
 *
 * */
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}



public class ValidateBST {
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */

    /* Traverse Methods --- no divide and conquer */
/*    private boolean isFirstNode = true;
    private int minVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null ) {
            return true;
        }
        boolean firstNode = true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!isFirstNode && minVal >= root.val){
            return false;
        }
        minVal = root.val;
        isFirstNode = false;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;*/



     /*   Version2: Divide and Conquer method*/

        class ResultType{
            private boolean isValid;
            private int minValue;
            private int maxValue;
            ResultType(boolean isValid, int minValue, int maxValue){
                this.isValid = isValid;
                this.minValue = minValue;
                this.maxValue = maxValue;
            }
        }

    public boolean isValidBST(TreeNode root){
        ResultType res = ValidateHelper(root);
        return res.isValid;
    }

    private ResultType ValidateHelper(TreeNode root){
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = ValidateHelper(root.left);
        ResultType right = ValidateHelper(root.right);

        if ( !left.isValid || !right.isValid) {
            return new ResultType(false, 0 ,0);
        }
        if (root.left != null && left.maxValue >= root.val ||
                root.right != null && right.minValue <= root.val){
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(root.val, right.maxValue),
                Math.min(root.val, left.minValue));

    }
}
