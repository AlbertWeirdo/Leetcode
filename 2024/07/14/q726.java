// 726. Number of Atoms
// https://leetcode.com/problems/number-of-atoms/description/

import java.util.HashMap;

class Solution {

    private HashMap<String, Integer> map = new HashMap<>();
    private int i=0;

    public String countOfAtoms(String formula) {
        char[] formulac = formula.toCharArray();
        
        while (i < formula.length()) {
            if (formulac[i] == '(') {

            }
            if (Character.isDigit(formulac[i + 1])) {

            } else {

            }
        }
    }

    private void 

}