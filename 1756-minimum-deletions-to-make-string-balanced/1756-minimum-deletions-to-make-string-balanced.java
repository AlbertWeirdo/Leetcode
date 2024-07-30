class Solution {
    public int minimumDeletions(String s) {
        int count_b=0;
        int min_deletion=0;
        for (char c:s.toCharArray()){
            if (c=='a'){
                min_deletion=Math.min(min_deletion+1, count_b);
            }else{
                count_b++;
            }
        }
        return min_deletion;
    }
}
