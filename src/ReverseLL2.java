/**
 * Created by Administrator on 2016/3/24.
 */
public class ReverseLL2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode res = new ReverseLL2().reverseBetween(head, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        res.next = head;
        ListNode cur = head;
        ListNode node = null;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                tmp = tmp.next;
                head = head.next;
                cur = head;
            } else {
                ListNode prev = head;
                head = head.next;
                prev.next = node;
                node = prev;
            }
        }
        tmp.next = node;
        if (cur != null) cur.next = head;
        return res.next;
    }
}
