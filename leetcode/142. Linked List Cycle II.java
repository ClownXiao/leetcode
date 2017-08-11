/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode detectCycle(ListNode head) {
        ListNode walk = head;
        ListNode run = head;
        boolean cycle = false;;
        while(walk!= null && run != null){
        	walk = walk.next;
        	if(run.next == null){
        		return null;
        	}
        	run = run.next.next;
        	if(walk == run){
        		cycle = true;
        		break;
        	}
        }
        if(!cycle) return null;
        walk = head;
        while(walk != run){
        	walk = walk.next;
        	run = run.next;
        }
        return walk;
    }
}