/**
 * Created by Nazli on 2016-11-13.
 */

/**
 * Question: http://www.lintcode.com/en/problem/convert-sorted-list-to-balanced-bst/
 * Solution Source: http://www.jiuzhang.com/solutions/convert-sorted-list-to-binary-search-tree/
 *
 * */
public class ConvertListTOBST {
    /**
     * Definition for ListNode.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int val) {
     *         this.val = val;
     *         this.next = null;
     *     }
     * }
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
         * @param head: The first node of linked list.
         * @return: a tree node
         */
        public class ListNode {
          int val;
          ListNode next;
          ListNode(int val) {
              this.val = val;
              this.next = null;
          }
        }
        public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
        }
        private static ListNode h;
//    Find the length of linked list
        public int lengthList(ListNode head){
            if(head == null){
                return 0;
            }
            int count = 0;
            while (head != null){
                count++;
                head = head.next;
            }
            return count;
        }
        public TreeNode sortedListToBST(ListNode head) {
            // write your code here
            if (head == null) {
                return null;
            }
            h = head;
            int len = lengthList(head);
            TreeNode node = sortedListToBST(len);
            return node;

        }
        public TreeNode sortedListToBST(int size){
            if (size <= 0){
                return null;
            }
            TreeNode left = sortedListToBST(size/2);
            TreeNode root = new TreeNode(h.val);
            h = h.next;
//            right child tree which
            TreeNode right = sortedListToBST(size - 1 - size/2);
            root.left = left;
            root.right = right;
            return root;
        }
}
