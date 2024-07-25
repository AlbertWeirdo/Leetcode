class Solution {
    public int[] sortArray(int[] nums) {
        Integer[] objNums=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(objNums, (a,b)->Integer.compare(a,b));
        return Arrays.stream(objNums).mapToInt(Integer::intValue).toArray();
    }
}