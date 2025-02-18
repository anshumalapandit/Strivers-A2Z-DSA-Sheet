class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=Integer.MIN_VALUE;
        int curCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                curCount++;
            }else{
                curCount=0;
            }
            if(curCount>maxCount){
                maxCount=curCount;
            }
        }
        return maxCount;
    }
}
