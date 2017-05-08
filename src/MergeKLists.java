/**
 * Created by Nazli on 2017-04-16.
 */

/*
* Question source: http://www.lintcode.com/en/problem/merge-k-sorted-lists/
* solution source: http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
* */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class MergeKLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */

    //  Using heap (priorityqueue) to merge lists

    public Comparator<ListNode> listcomparator = new Comparator<ListNode>() {
        public int compare(ListNode list1, ListNode list2){
            return list1.val - list2.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here

        if (lists.size() == 0 || lists == null)
            return null;

        ListNode node = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), listcomparator);

        // put the list into heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null ) {
                queue.add(lists.get(i));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        // Compare heap elements
        while (!queue.isEmpty()){
            ListNode minnode = queue.poll();
            tail.next = minnode;
            tail = minnode;
            if (minnode.next != null) {
                queue.add(minnode.next);
            }
        }

        return head.next;

    }

}
