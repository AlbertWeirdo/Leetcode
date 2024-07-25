import java.util.HashSet;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!map.contains(j)) {
                        map.add(j);
                        break;
                    }
                }
            }
        }
        int count = 0;
        int[] ans = new int[map.size()];
        for (int i : map) {
            ans[count] = nums2[i];
            count++;
        }
        return ans;
    }
}