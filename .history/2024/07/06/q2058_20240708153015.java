// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class q2058 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] values = { 48, 48, 18, 26, 58, 79, 5, 95, 39, 78, 86, 39, 54, 15, 55, 54, 45, 97, 64, 33, 6, 93, 73, 93,
                89, 63, 30, 35, 52, 8, 4, 51, 25, 99, 54, 47, 67, 12 };
        ListNode head = createLinkedList(values);

        int[] ans = s.nodesBetweenCriticalPoints(head);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0)
            return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private HashSet<Integer> criticalLoc = new HashSet<>();
    private int loc = 0;
    private int previous = 0;

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        // ans[0] = Integer.MAX_VALUE;
        while (head.next != null) {
            if (loc == 0) {
                previous = head.val;
                loc++;
                head = head.next;
            } else {
                if (checkCritical(head)) {
                    criticalLoc.add(loc);
                }
                loc++;
                head = head.next;
            }
        }
        if (criticalLoc.size() >= 2) {
            int max1 = Collections.max(criticalLoc);
            int min = Collections.min(criticalLoc);
            ans[0] = Integer.MAX_VALUE;
            Integer[] loc = criticalLoc.toArray(new Integer[criticalLoc.size()]);
            Arrays.sort(loc);
            ans[0] = Integer.MAX_VALUE;
            for (int i = 1; i < loc.length; i++) {
                ans[0] = Math.min(ans[0], loc[i] - loc[i - 1]);
            }

            ans[1] = max1 - min;
        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public boolean checkCritical(ListNode head) {
        if ((head.val > previous) && (head.val > head.next.val)) {
            previous = head.val;
            return true;
        } else if ((head.val < previous) && (head.val < head.next.val)) {
            previous = head.val;
            return true;
        } else {
            previous = head.val;
            return false;
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}