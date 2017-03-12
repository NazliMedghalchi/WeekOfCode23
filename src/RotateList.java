/**
 * Created by Nazli on 2016-11-11.
 */
/**
 * Question: http://www.lintcode.com/en/problem/rotate-list/
 * Solution source: http://www.jiuzhang.com/solutions/rotate-list/
 * */
public class RotateList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
        /**
         * @param head: the List
         * @param k: rotate to the right k places
         * @return: the list after rotation
         */
        public ListNode rotateRight(ListNode head, int k) {
            // write your code here
            if (head == null){
                return null;
            }
            int count = 0;
            // count gives the length of linked list
            ListNode n = head;
            while (n != null){
                count++;
                n = n.next;
            }

            ListNode node = new ListNode(0);
            node.next = head;
            head = node;

            ListNode tail = node;
            // The shift value is divided by length so as to eliminate duplication in rotation
            count = k % count;
            int c = 0;
            for (c = 0; c < count; c++){
                head = head.next;
            }
            while (head.next != null){
                tail = tail.next;
                head = head.next;
            }
            head.next = node.next;
            node.next = tail.next;
            tail.next = null;

            return node.next;
        }
}
