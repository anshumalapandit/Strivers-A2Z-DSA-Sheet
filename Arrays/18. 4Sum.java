class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
     List<List<Integer>> ans=new ArrayList<>();
     // dont forget to sorts the array
     Arrays.sort(nums);
     for(int i=0;i<nums.length;i++){
        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }
        for(int j=i+1;j<nums.length;j++){
            if(j>i+1 && nums[j]==nums[j-1]){
                continue;
            }
            int k=j+1;
            int l=nums.length-1;
            while(k<l){
                // most imp thing
                // dont add ek sath  otherwise overflow ho jayesga and use long
                long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                if(sum<target){
                   // needs to inc something
                   k++;
                }else if(sum>target){
                 //needs to dec something
                 l--;
                }
                else if(sum==target){
                    List<Integer> subans=new ArrayList<>();
                    subans.add(nums[i]);
                    subans.add(nums[j]);
                    subans.add(nums[k]);
                    subans.add(nums[l]);
                    ans.add(subans);
                // now i dont want elem at kth and lth again
                k++;
                l--;
                while(k<l && nums[k]==nums[k-1]){
                    k++;
                }
                while(k<l && nums[l]==nums[l+1]){
                    l--;
                }
            }
        }

     }   
    }
    return ans;
    }
}
