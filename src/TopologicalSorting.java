import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Question source: http://www.lintcode.com/en/problem/topological-sorting/
 * Solution source: http://www.jiuzhang.com/solutions/topological-sorting/
 *
 *
 *
 * */
/**
 * Created by Nazli on 2017-01-04.
 */
public class TopologicalSorting {


    class DirectedGraphNode {
          int label;
          ArrayList<DirectedGraphNode> neighbors;
          DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };
    /**
     * Definition for Directed graph.
     * class DirectedGraphNode {
     *     int label;
     *     ArrayList<DirectedGraphNode> neighbors;
     *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
     * };
     */
        /**
         * @param graph: A list of Directed graph node
         * @return: Any topological order for the given graph.
         */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        if (graph == null){
            return order;
        }

        // First for every node's neighbors put them all in a hashmap with a vallue of 1
        // If it's seen before increses the value by one
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode neighbor : node.neighbors){
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, 1);
                }
                else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }
        // Now for every node in the graph if it doesn't exsit in the hashmap add it to queue and results
        for (DirectedGraphNode node : graph){
            if (!map.containsKey(node)){
                queue.offer(node);
                order.add(node);
            }
        }

        // Check every node in the queue for all its neighbors
        // Update the map by reducing one
        // if the value is zero, then all neighbors are visited

        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0){
                    order.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }

}
