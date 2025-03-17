class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            // check either part is sorted
            if(nums[l]<=nums[mid]){
                // now i am damn sure ki left part sorted hai
                // now check in left 
                if(nums[l]<=target && target<=nums[mid]){
                    // target left mai hai eliminate right part
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                // now i am damn sure ki right part sorted hai 
                // now  check in right
                if(nums[mid]<=target && target<=nums[r]){
                    // eliminate left part
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
