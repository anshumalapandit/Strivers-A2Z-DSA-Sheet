class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(i<nums.length){
            int cur=nums[i];
            if(cur!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }else if(cur==0){
                i++;
            }
        }
    }
}
