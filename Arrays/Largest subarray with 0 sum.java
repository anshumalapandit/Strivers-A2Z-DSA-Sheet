class Solution {
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }
                // check kya sum map mai exist karta hai
                if(!map.containsKey(sum)){
                    map.put(sum,i);
                }else{
                    // if its exist in map
                    int curLen=i-map.get(sum);
                    max=Math.max(curLen,max);
                }
            
        }
        return max==Integer.MIN_VALUE? 0:max;
    }
}
