/**
 * Created by Nazli on 2016-11-14.
 */
/**
 * Question: http://www.lintcode.com/en/problem/sort-list/
 * Solution source: http://www.jiuzhang.com/solutions/sort-list/
 * Solution based on MergeSort, QuickSort1 and QuickSort2
 * */
public class SortList {
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
         * @return: You should return the head of the sorted linked list,
        using constant space complexity.
         */
        //  MergeSort
        private ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        private ListNode merge(ListNode left, ListNode right){
            ListNode dummy = new ListNode(0);
            ListNode node = dummy;
            while (left != null && right != null){
                if (left.val < right.val){
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
                node = node.next;
            }
            if (right != null){
                node.next = right;
            }
            if (left != null){
                node.next = left;
            }
            return dummy.next;
        }
        private int getLength(ListNode head){
            ListNode dummy = head;
            if (dummy == null){
                return 0;
            }
            int len = 0;
            while (dummy != null){
                len++;
                dummy = dummy.next;
            }
            return len;
        }

        private ListNode concat(ListNode left, ListNode middle, ListNode right){
            ListNode list = new ListNode(0);
            ListNode dummy = list;
            list.next = left;
            list = getTail(list);
            list.next = middle;
            list = getTail(list);
            list.next = right;
            list = getTail(list);
            return dummy.next;
        }

        private ListNode getTail(ListNode node){
            if (node == null){
                return null;
            }
            while (node.next != null){
                node = node.next;
            }
            return node;
        }
        public ListNode sortList(ListNode head) {
            // write your code here

//           MERGESORT
//            if (head == null || head.next == null){
//                return head;
//            }
//            ListNode node = new ListNode(0);
//            // find mid point
//            // i nt len = getLength(head);
//            ListNode mid = findMiddle(head);
//            // sort right
//            ListNode right = sortList(mid.next);
//            mid.next = null;
//            // sort left
//            ListNode left = sortList(head);
//
//            // merge left anf right
//            return merge(left, right);
//
//          QUICKSORT
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode middle = new ListNode(0);
        ListNode leftNode = left;
        ListNode rightNode = right;
        ListNode middleNode = middle;

        ListNode mid = findMiddle(head);
            while (head != null){
            if (head.val < mid.val){
                left.next = head;
                left = head;
            } else if (head.val > mid.val){
                right.next = head;
                right = head;
            } else {
                middle.next = head;
                middle = head;
            }
            head = head.next;
        }

        left.next = null;
        right.next = null;
        middle.next = null;

        ListNode leftSorted = sortList(leftNode.next);
        ListNode rightSorted = sortList(rightNode.next);

        ListNode result = concat(leftSorted, middleNode.next, rightSorted);
        return result;
        }
}
