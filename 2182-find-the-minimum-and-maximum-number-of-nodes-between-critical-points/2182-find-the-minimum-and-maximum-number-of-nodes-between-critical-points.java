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