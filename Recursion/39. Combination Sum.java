class Solution {
    public void helper(int idx,int arr[],int target,List<List<Integer>> ans,List<Integer> list){
        // base case
        if(idx==arr.length){
            if(target==0){
                // then i will add my combinations till now what i got will add in main list
                ans.add(new ArrayList<>(list)); // it takes linear time dont assume constant time
            }
            return;
        }
        // at every step i have 2 option  pick not pick
        // i will try to pick same elem again & again
        if(arr[idx]<=target){
            // if current element is smaller == to target then only i will make recursive call for same elem again & ag
            list.add(arr[idx]);
            helper(idx,arr,target-arr[idx],ans,list); // if this part is done 
        // before making call to non pick remove it 
           list.remove(list.size()-1);
        }
        // non pick
        helper(idx+1,arr,target,ans,list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
