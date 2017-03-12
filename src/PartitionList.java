/**
 * Created by Nazli on 2016-11-09.
 */
/**
 * Question: http://www.jiuzhang.com/solutions/partition-list/
 * Solution source:
 *
 * */
public class PartitionList {
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
         * @param x: an integer
         * @return: a ListNode
         */
        public ListNode partition(ListNode head, int x) {
            // write your code here
            if (head == null) {
                return null;
            }
            ListNode l1 = new ListNode(0);
            ListNode l2 = new ListNode(0);
            ListNode left = l1;
            ListNode right = l2;

            while (head != null){
                if (head.val < x) {
                    left.next = head;
                    left = head;
                } else if (head.val >= x) {
                    right.next = head;
                    right = head;
                }
                head = head.next;
            }
            // set end of list to null
            right.next = null;
            // set the starting point of list
            left.next = l2.next;
            // return the partitioned list
            return l1.next;
        }

}
