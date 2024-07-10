// 2192. All Ancestors of a Node in a Directed Acyclic Graph
// https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-06-29

import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class q2192 {
    public static Solution s = new Solution();

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = { { 0, 7 }, { 7, 6 }, { 0, 3 }, { 6, 3 }, { 5, 4 }, { 1, 5 }, { 2, 7 }, { 3, 5 }, { 3, 1 },
                { 0, 5 }, { 7, 5 }, { 2, 1 }, { 1, 4 }, { 6, 1 } };
        s.getAncestors(n, edges);

    }
}

class Solution {
    private ArrayList<List<Integer>> ans = new ArrayList<>();
    private int v;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            List<Integer> subAns = new ArrayList<>();
            ans.add(subAns);
        }
        for (int i = 0; i < edges.length; i++) {
            List<Integer> subAns = ans.get(edges[i][1]);
            subAns.add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> temp = deepCopy(ans.get(i));
            List<Integer> subAns = ans.get(i);
            for (int k : temp) {
                List<Integer> toAdd = ans.get(k);
                for (int j : toAdd) {
                    if (!subAns.contains(j)) {
                        subAns.add(j);
                    }
                }
            }
            subAns.sort(Comparator.naturalOrder());
        }

        return ans;
    }

    private List<Integer> deepCopy(List<Integer> list) {
        List<Integer> subAns = new ArrayList<>();
        for (int i : list) {
            this.v = i;
            subAns.add(v);
        }
        return subAns;
    }

}