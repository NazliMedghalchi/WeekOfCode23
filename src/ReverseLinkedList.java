/**
 * Created by Nazli on 2016-11-09.
 */

/**
* Question: http://www.lintcode.com/en/problem/reverse-linked-list/
 * Solution source: https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73011
 * http://www.jiuzhang.com/solutions/reverse-linked-list/
* */
public class ReverseLinkedList {
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
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // // write your code here
        // if (head == null){
        //     return null;
        // }
        // ListNode reverse = new ListNode(0);
        ListNode r = null;
        ListNode node = head;
        ListNode temp = node;
        while (node != null) {
            temp = node.next;
            node.next = r;
            r = node;
            node = temp;
        }
        //
        head = r;
        return head;
    }
}
