/**
 * Created by Nazli on 2016-11-13.
 */

/**
 * Question: http://www.lintcode.com/en/problem/linked-list-cycle/
 * Solution source: http://www.jiuzhang.com/solutions/linked-list-cycle/
 *
 * */
public class ListHasCycle {
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
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int val) {
              this.val = val;
              this.next = null;
          }
     }
        /**
         * @param head: The first node of linked list.
         * @return: True if it has a cycle, or false
         */
        public boolean hasCycle(ListNode head) {
            // write your code here
            if (head == null || head.next == null){
                return false;
            }
            ListNode hLeft = head; // slow
            ListNode hRight = head.next; // fast
//            Right pointer 2 steps to front of linkedlist
            while(hLeft != hRight){
                if(hRight == null || hRight.next == null){
                    return false;
                }
                hRight = hRight.next.next;
                hLeft = hLeft.next;
            }
            return true;

        }


}
