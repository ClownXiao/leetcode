/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int count = 0;
    
    HashMap<Integer, Integer> old = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        travel(root, sum);
        return count;
    }
    
    public void travel(TreeNode node, int sum){
        if(node == null)
            return;
        
        update(node.val, true);
        if(old.containsKey(sum)){
            count += old.get(sum); 
        }
        travel(node.left, sum);
        travel(node.right, sum);
        update(-node.val, false);
    }

    public void update(int v, boolean down){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Map.Entry<Integer, Integer> e: old.entrySet()){
            int vv = e.getKey() + v;
            map.put(vv, map.getOrDefault(vv, 0) + e.getValue());
        }
        if(down){
            map.put(v,  map.getOrDefault(v, 0) + 1);
        }
        else{
            if(map.get(0) == 1)
                map.remove(0);
            else
                map.put(0, map.get(0) - 1);
        }
        old = map;
    }
}