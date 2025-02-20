class Solution {
    public int longestConsecutive(int[] nums) {
     int count=1;
     int longest=Integer.MIN_VALUE;
     if(nums.length==0){
        return 0;
     }
     Arrays.sort(nums);
     int lastSmallest=nums[0];
     for(int i=1;i<nums.length;i++){
        if(nums[i]>lastSmallest){
               if(nums[i]==lastSmallest+1){
                count++;
                lastSmallest=nums[i];
               }else{
               longest=Math.max(longest,count);
                count=1;
                lastSmallest=nums[i];
               }
        }
     }
     longest=Math.max(longest,count);
     return longest;  
    }
}
// optimised 
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length==0){
            return 0;
        }
        int longest=1;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int cur:set){
            // if first num then only
            if(!set.contains(cur-1)){
               int count=1;
               int x=cur;
            while(set.contains(x+1)){
                count++;
                x=x+1;
            }
            longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}
