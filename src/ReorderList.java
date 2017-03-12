/**
 * Created by Nazli on 2016-11-14.
 */

/**
 * Question: http://www.lintcode.com/en/problem/reorder-list/
 * Solution source: http://www.jiuzhang.com/solutions/reorder-list/
 *
 *
 * **/
public class ReorderList {
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
         * @param head: The head of linked list.
         * @return: void
         */
        public ListNode middle(ListNode head){
            if (head == null){
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                // slow covers odd indeces
                slow = slow.next;
                // fast covers even indeces
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head){
            if (head == null){
                return null;
            }
            ListNode node = null;
            while(head != null){
                ListNode temp = head.next;
                head.next = node;
                node = head;
                head = temp;
            }
            return node;
        }

        public void merge(ListNode head, ListNode tail){
            if (head == null || tail == null){
                return;
            }
            ListNode node = new ListNode(0);
            int index = 0;
            while(head != null && tail != null){
                if (index % 2 == 0){
                    node.next = head;
                    head = head.next;
                }else {
                    node.next = tail;
                    tail = tail.next;
                }
                node = node.next;
                index++;
            }
            if (head != null){
                node.next = head;
            }
            if (tail != null){
                node.next = tail;
            }
        }

        public void reorderList(ListNode head) {
            // write your code here
            if(head == null || head.next == null){
                return;
            }
            ListNode mid = middle(head);
            ListNode tail = reverse(mid.next);
            mid.next = null;
            merge(head, tail);
        }

}
