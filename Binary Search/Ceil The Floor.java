class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int start=0;
        int end=arr.length-1;
        int largest=-1;
        int smallest=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            // if statement = > arr[mid]==x we want both floor and ceil to be updated 
            // agar if-else use karenge to bas floor update hoga which is wrong
            if(arr[mid]<=x){
                largest=arr[mid];
                // want largest go to right side
                start=mid+1;
            }
             if(arr[mid]>=x){
                    smallest=arr[mid];
                    // want smallest go to left side
                    end=mid-1;
            }
            
        }
        int ans[]=new int[2];
        ans[0]=largest;
        ans[1]=smallest;
        return ans;
    }
}
