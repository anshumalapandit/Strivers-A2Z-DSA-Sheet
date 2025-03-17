class Solution {
    public int reverse(int x) {
        int ans=0;
        boolean isNeg=true;
        if(x>0){
           isNeg=false;
        }
        int temp=Math.abs(x);
        //     Signed 32-bit integer ka range hota hai:

// Minimum value: Integer.MIN_VALUE = -2^31 = -2147483648 
// Maximum value: Integer.MAX_VALUE = 2^31 - 1 = 2147483647
        while(temp!=0){
            int ld=temp%10;
            if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && ld==7)){
                return 0;
            }
             if(ans<Integer.MIN_VALUE/10 || (ans==Integer.MIN_VALUE/10 && ld==-8)){
                return 0;
            }
            ans=ans*10+ld;
            temp=temp/10;
        }
        if(isNeg){
            ans=ans*(-1);
            return ans;
        }
        if(ans>=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE){
            return 0;
        }
        return ans;
    }
}
