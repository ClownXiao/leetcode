/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;

        ListNode l1 = head, l2 = head;
        ListNode pre = l1;
        while(l2 != null && l2.next != null){
        	pre = l1;
        	l1 = l1.next;
        	l2 = l2.next.next;
        }

        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(l1);

        return merge(left, right);

    }

    public ListNode merge(ListNode l1, ListNode l2){
    	ListNode l = new ListNode(0);
    	ListNode t = l;
    	while(l1 != null && l2!= null){
    		if(l1.val < l2.val){
    			t.next = l1;
                l1 = l1.next;
            }
    		else{
    			t.next = l2;
                l2 = l2.next;
            }
    		t = t.next;
    	}
    	if(l1 != null)
    		t.next = l1;
    	else if(l2 != null)
    		t.next = l2;
    	return l.next;
    }
}