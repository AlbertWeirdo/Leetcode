// 1598. Crawler Log Folder
// https://leetcode.com/problems/crawler-log-folder/description/

public class q1598 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
        System.out.println(s.minOperations(logs));
    }
}

class Solution {
    private int distanceFromMain = 0;

    public int minOperations(String[] logs) {  
        for (int i=0;i<logs.length;i++){
            if (logs[i].equals("../")){
                if (distanceFromMain==0){
                    
                }
            }
        }

        return ans
    }
}