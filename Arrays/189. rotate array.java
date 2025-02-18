class Solution {
    public void reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length-1;
        k=k%nums.length; // reduce extra rotation
        reverse(nums,nums.length-k,n);
        reverse(nums,0,nums.length-k-1);
        reverse(nums,0,n);
    }
}
