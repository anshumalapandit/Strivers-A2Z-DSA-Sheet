class Solution {
    public String largestOddNumber(String num) {
        char ch_arr[]=num.toCharArray();
        int arr[]=new int[ch_arr.length];
        for(int i=0;i<ch_arr.length;i++){
            arr[i]=ch_arr[i]-'0';
        }
        int idx=0;
        boolean flag=false; // Assuming ki odd to nhi hoga hi
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                // if it is odd only then
                flag=true;
                idx=i;
            }
        }
        if(flag==false){
            return "";
         }
        return num.substring(0,idx+1);
    }
}
