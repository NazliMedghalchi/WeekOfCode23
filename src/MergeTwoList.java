/**
 * Created by Nazli on 2016-11-08.
 */
/**
 * Question: http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 * Solution source: http://www.jiuzhang.com/solutions/merge-two-sorted-lists/
 *
 * */
public class MergeTwoList {/**
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        // if (l1 == null){
        //     return l2;
        // }
        // if (l2 == null){
        //     return l1;
        // }

        ListNode init = new ListNode(0);
        ListNode list = init;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                list.next = l1;
                l1 = l1.next;
            }
            else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        if (l1 != null ) {
            list.next = l1;
        }
        else if (l2 != null){
            list.next = l2;
        }
        return init.next;
    }
}
