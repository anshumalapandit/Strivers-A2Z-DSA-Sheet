class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        // most imp things dont forget to sort array remember 2 pointer needs sorting
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // same for i dont want previous if its equivalent
             if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements for 'i'
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                 // need to inc something
                 j++;
                }else if(sum>0){
                    // nedd to dec something
                    k--;
                }else{
                // means its ==0 but i dont want that elem again so move 
                List<Integer> subans=new ArrayList<>();
                subans.add(nums[i]);
                subans.add(nums[j]);
                subans.add(nums[k]);
                ans.add(subans);
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]){
                    // if its equalvalent to previous one j++
                    j++;
                }
                while(j<k && nums[k]==nums[k+1]){
                    k--;
                }
                }
            }
        }
        return ans;
    }
}
