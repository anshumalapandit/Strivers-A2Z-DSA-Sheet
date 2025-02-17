

// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int firstLar=-1;
        int secLar=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>firstLar){
                
                secLar=firstLar;
                firstLar=arr[i];
            }else if( arr[i]<firstLar && arr[i]>secLar){
                secLar=arr[i];
            }
        }
        return secLar;
    }
}
