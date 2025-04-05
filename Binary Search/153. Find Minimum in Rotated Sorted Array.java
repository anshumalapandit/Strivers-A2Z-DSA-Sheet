//worst case= 0(n)
class Solution {
    public int findMin(int[] nums) {
        // first i will find mera array kitne se rotated say then i will return first elemtn
        int prev=nums[0];
        int ansIdx=0;
        for(int i=1;i<nums.length;i++){
            if(prev>nums[i]){
                // its rotated point
                ansIdx=i;
                break;
            }
            prev=nums[i];
        }
        return nums[ansIdx];
    }
}
// optimised approach:
class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
         int mid=start+(end-start)/2;
         if(nums[mid]>nums[end]){
           // gadbad
           // answer right side hi lie karta hai 
           start=mid+1; // mid+1 isiliye mid to bada hai to ye to answer nhi ho sakta
         }else{
          // if asa nhi hai update end pointer
          end=mid; // here we dont do mid-1 coz mid chota hai to ye bhi answer ho sakta hai 
         }
        }
        // imp to remember dont do start<=end otherwise loop mai fas jaoge
        return nums[end];
    }
}
