/**
 * Created by Administrator on 2015/11/25.
 */
public class reverseKGroup {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode root = new reverseKGroup().reverse(l1, 2);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode reverse(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l1 = dummy, l2 = dummy;

        while (l2 != null) {
            for (int i = 0; i <= k; i++) {
                if (l2 == null) return dummy.next;
                l2 = l2.next;
            }

            ListNode pre = null;
            ListNode tmp = l1;
            l1 = l1.next;
            while(l1 != l2) {
                ListNode next = l1.next;
                l1.next = pre;
                pre = l1;
                l1 = next;
            }
            l1 = tmp.next;
            l1.next = l2;
            l2 = tmp.next;
            tmp.next = pre;
        }
        return dummy.next;
    }
}
