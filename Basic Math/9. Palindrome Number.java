class Solution {
    public boolean isPalindrome(int x) {
        int ans=0;

        if(x<0){
            return false;
        }
        int temp=x;

        while(temp!=0){
            int ld=temp%10;
            ans=ans*10+ld;
            temp=temp/10;
        }
        if(x==ans){
            return true;
        }
        return false;
    }
}
