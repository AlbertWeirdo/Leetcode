// 1190. Reverse Substrings Between Each Pair of Parentheses
// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class q1190 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(u(love)i)";
        System.out.println(s.reverseParentheses(str));
    }
}

class Solution {
    int i = 0;

    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder();

        while (i < s.length) {
            if (s[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s[i] == '(') {
                i++;
                String st = helper(s);
                sb.append(st);
            } else {
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}
