class Solution {
    private HashMap<Integer, String> map=new HashMap<>();
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        String[] ans=new String[names.length];
        Arrays.sort(heights);
        for (int i=0;i<heights.length;i++){
            ans[i]=map.get(heights[heights.length-i-1]);
        }
        return ans;

    }
}