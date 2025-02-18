class Solution {
    public boolean check(int[] nums) {
        int peak=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%n]){
                peak++;
            }
        }
        return peak<=1;
    }
}
