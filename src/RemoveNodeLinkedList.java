/**
 * Created by Nazli on 2016-11-08.
 */
/**
 * Question: http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 * Solution source: http://www.jiuzhang.com/solutions/remove-nth-node-from-end-of-list/
 *
 * */
public class RemoveNodeLinkedList {
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
         * @param n: An integer.
         * @return: The head of linked list.
         */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || head.next == null || n <=0) return null;

        int count = 0;
        ListNode init = new ListNode(0);
        init.next = head;
        ListNode temp = init;
        // find the nth value
        while(temp.next != null && count < n) {
            count++;
            head = head.next;
        }
    /* ListNode h = head.next;
     continue forward after nth value for listnode head and start moving
     temp forward */
        while(head != null){
            head = head.next;
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return init.next;
    }

}
