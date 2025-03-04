class Solution {

    static int findFloor(int[] arr, int x) {
        // write code here
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=x){
                ans=mid;
            }
            if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}
