class Solution{
    public int[] sortArray(int[] nums){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int[] occurrence=new int[100001];
        int valAfterMapping=0;
        
        for (int i:nums){
            valAfterMapping=50000+i;
            if (valAfterMapping>max){
                max=valAfterMapping;
            }if (valAfterMapping<min){
                min=valAfterMapping;
            }
            occurrence[valAfterMapping]++;
        }
        int length=nums.length-1;
        for (int i=max;i>=min;i--){
            if (occurrence[i]==0){
                continue;
            }
            int occurrenceLength=occurrence[i];
            while (occurrenceLength-->0){
                nums[length--]=(i-50000);
            }
            
        }
        return nums;
    }
}

