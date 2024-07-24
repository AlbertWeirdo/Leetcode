class Solution {
    private HashMap<Integer,HashSet<Integer>> map=new HashMap<>();

    private int[] ans;
    public int[] sortJumbled(int[] mapping, int[] nums) {

        ans=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int newValue=0;
            int num=nums[i];
            int digit=1;
            if (num==0){
                newValue=mapping[0];
            }else{
                while (num>0){
                    newValue+=mapping[num%10]*digit;
                    num/=10;
                    digit*=10;
                }
            }
   
            if (map.containsKey(newValue)){
                HashSet<Integer> set=map.get(newValue);
                set.add(i);
                map.put(newValue, set);
            }else{
                HashSet<Integer> set=new HashSet<>();
                set.add(i);
                map.put(newValue, set);
            }
        }
        ArrayList<Integer> list=new ArrayList<>(map.keySet());
        Collections.sort(list);
        int count=0;
        for (int i:list){
            HashSet<Integer> set=map.get(i);
            for (int j:set){
                ans[count]=nums[j];
                count++;
            }
        }
        return ans;
    }
}
