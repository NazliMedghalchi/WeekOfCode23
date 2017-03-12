import java.util.HashMap;

/**
 * Created by Nazli on 2016-11-13.
 */
/**
 * Question: http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
 * Solution Source: http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
 *
 * */
public class CopyListWithRandom {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
     };
        /**
         * @param head: The head of linked list with a random pointer.
         * @return: A new head of a deep copy of the list.
         */

        //  No Hashmap
     /*public void copyList(RandomListNode head){
        while (head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    public void copyRandom(RandomListNode head){
        while(head != null){
            if (head.next.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    public RandomListNode splitList(RandomListNode head){
        RandomListNode node = head.next;
        while(head != null){
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return node;
    } */
        public RandomListNode copyRandomList(RandomListNode head) {
            // write your code here
            if (head == null) {
                return null;
            }
        /*
        RandomListNode node = new RandomListNode(0);
        RandomListNode h = head;
        node.next = h;
        int count = 0;
        RandomListNode counter = head;
        while(counter != null){
            count++;
            counter = counter.next;
        }
        // copy the nodes into a new list by linking new nodes between every node and its next node
        copyList(head);
        copyRandom(head);
        return splitList(head);
        */


            // With HashMap
            HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
            RandomListNode newNode = new RandomListNode(0);
            RandomListNode temp = newNode;
            RandomListNode node = newNode;

            while(head != null){
                if(map.containsKey(head)){
                    newNode = map.get(head);
                }else{
                    newNode = new RandomListNode(head.label);
                    map.put(head, newNode);
                }
                temp.next = newNode;
                if(head.random != null){
                    if(map.containsKey(head.random)){
                        newNode.random = map.get(head.random);
                    }else {
                        newNode.random = new RandomListNode(head.random.label);
                        map.put(head.random, newNode.random);
                    }

                }
                temp = newNode;
                head = head.next;
            }
            return node;

        }
}
