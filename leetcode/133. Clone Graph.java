/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null)
            return null;
        
    	if(map.containsKey(node.label))
    		return map.get(node.label);

    	UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);
        
    	for(UndirectedGraphNode n: node.neighbors){
    		cloneNode.neighbors.add(cloneGraph(n));
    	}
    	return cloneNode;
        
    }

}