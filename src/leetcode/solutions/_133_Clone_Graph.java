package leetcode.solutions;

import leetcode.common.classes.UndirectedGraphNode;

import java.util.*;

/**
 * 133. Clone Graph
 * <p>
 * Clone an undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * <p>
 *          1
 *         / \
 *        /   \
 *       0 --- 2
 *            / \
 *            \_/
 *
 * Note:
 *
 * The number of nodes will be between 1 and 100.
 * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
 * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
 * You must return the copy of the given node as a reference to the cloned graph.
 */
public class _133_Clone_Graph {

    public static class Solution1 {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if (node == null) {
                return node;
            }

            Map<Integer, UndirectedGraphNode> map = new HashMap();
            Queue<UndirectedGraphNode> queue = new LinkedList();
            UndirectedGraphNode root = new UndirectedGraphNode(node.label);
            map.put(root.label, root);
            queue.offer(node);
            //remember to offer the original input node into the queue which contains all the information
            while (!queue.isEmpty()) {
                UndirectedGraphNode curr = queue.poll();
                for (UndirectedGraphNode eachNode : curr.neighbors) {
                    if (!map.containsKey(eachNode.label)) {
                        map.put(eachNode.label, new UndirectedGraphNode(eachNode.label));
                        queue.offer(eachNode);
                    }
                    map.get(curr.label).neighbors.add(map.get(eachNode.label));
                }
            }
            return root;
        }
    }
    public static class Solution2{
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            Map<Integer, Node> map = new HashMap();
            Queue<Node> queue = new LinkedList();
            Node root = new Node(node.val, new ArrayList());
            map.put(root.val, root);
            queue.offer(node);
            //remember to offer the original input node into the queue which contains all the information
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                for (Node eachNode : curr.neighbors) {
                    if (!map.containsKey(eachNode.val)) {
                        map.put(eachNode.val, new Node(eachNode.val, new ArrayList()));
                        queue.offer(eachNode);
                    }
                    map.get(curr.val).neighbors.add(map.get(eachNode.val));
                }
            }
            return root;
        }
    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
