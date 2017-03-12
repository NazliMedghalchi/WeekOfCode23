/**
 * Created by Nazli on 2016-11-08.
 */
/**
 * Question: http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/
 * Solution osurce: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-list/
 *
 * */
public class RemoveDupFromSortedList {
    /**
     * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) return null;

        ListNode l1 = head;

        while (l1.next != null){
            ListNode l2 = l1.next;
            if (l1.val == l2.val){
                l1.next = l2.next;
            }
            else {
                l1 = l1.next;
            }
        }
        return head;
    }

}
