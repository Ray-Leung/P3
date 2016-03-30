import java.util.LinkedList;

/**
 * Created by Administrator on 2015/12/27.
 */
public class RotateList {
    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        ListNode h0 = head;
        ListNode h1 = null;

        int len = 0;

        while (h0.next != null) {
            h0 = h0.next;
            len++;

            if (len == k+1) {
                h1 = head;
            }

            if (len > k) {
                h1 = h1.next;
            }

            if (h0.next == null) {
                len++;

                if (len == k + 1) {
                    h1 = head;
                    break;
                }
                if (k % len == 0) return head;

                if (k > len) {
                    k %= len;
                    h0 = head;
                    len = 0;
                }
            }

        }
        ListNode res = h1.next;
        h1.next = null;
        h0.next = head;
        return res;

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        ListNode head = new ListNode(1);
        ListNode tmp = head;

        for (int i = 1; i < nums.length;i++) {
           tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
       ListNode n = new RotateList().rotateRight(head, 11);
    }
}
