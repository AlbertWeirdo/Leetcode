class Solution {
    private HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
    private HashMap<Integer,Integer> usedNum=new HashMap<>();
    public int[] frequencySort(int[] nums) {
        int[] ans=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            HashSet<Integer> oldSet=new HashSet<>();
            if (!usedNum.containsKey(nums[i])){
                usedNum.put(nums[i], 1);
                if (!map.containsKey(1)){
                    oldSet.add(nums[i]);
                    map.put(1, oldSet);
                }else{
                    oldSet=map.get(1);
                    oldSet.add(nums[i]);
                    map.put(1,oldSet);
                }

            }else{
                HashSet<Integer> newSet=new HashSet<>();
                int freq=usedNum.get(nums[i]);
                usedNum.put(nums[i], freq+1);
                oldSet=map.get(freq);
                oldSet.remove(nums[i]);
                map.put(freq, oldSet);
                if (map.containsKey(freq+1)){
                    newSet=map.get(freq+1);
                    newSet.add(nums[i]);
                }else{
                    newSet.add(nums[i]);
                }    
                map.put(freq+1, newSet);
            }

        }
        ArrayList<Integer> aList=new ArrayList<>(map.keySet());
        Collections.sort(aList);
        int count=0;
        for (int i:aList){
            HashSet<Integer> set=map.get(i);
            ArrayList<Integer> aList2=new ArrayList<>(set);
            if (set.size()>1){
                Collections.sort(aList2);
            }
            int temp=1;
            
            for (int j:aList2){
                int repeat=0;
                while (repeat<i){
                    ans[count+(set.size()-temp)*i+repeat]=j;
                    repeat++;
                }
                temp++;
            }
            count+=set.size()*i;
        }
        return ans;
    }
}