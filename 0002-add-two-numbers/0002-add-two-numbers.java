/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();

        ListNode next =  res;

        int carryOver = 0;

        while(l1 !=null || l2 != null) {
            int r1 = 0;
            int r2 = 0;

            if(l1 != null) {
                r1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                r2 = l2.val;
                l2 = l2.next;
            }

            int sum = r1+r2+carryOver;

            next.val = sum % 10;

            carryOver = sum / 10;

            if(l1 !=null || l2 !=null) {
                ListNode nextNode = new ListNode();
                next.next = nextNode;
                next = nextNode;
            }
        }

        if(carryOver != 0) {
            ListNode nextNode = new ListNode();
            nextNode.val = carryOver;
            next.next = nextNode;
        }

        return res;
    }
}