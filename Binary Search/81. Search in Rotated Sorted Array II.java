class Solution {
    public boolean search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            // but what if low==high==mid here we stuck so just shrink the array
            if(nums[l]==nums[mid] && nums[mid]==nums[r]){
                l++;
                r--;
                continue; // coz for this case i wont want to do comparision
            }
            // rest code as it is part I quest 
            if(nums[l]<=nums[mid]){
                // if starting elemnt smaller than mid i must sure that left part is sorted
                // now check sach mai ?
                if(nums[l]<=target && target<=nums[mid]){
                    // if yes then eliminate right part
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                // same for right part
                if(nums[mid]<=target && target<=nums[r]){
                    // if its is lies here then eliminate left part
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}
