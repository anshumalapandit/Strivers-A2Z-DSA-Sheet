class Solution {
    static int evenlyDivides(int n) {
        // code here
        
        int count=0;
        int num=n;
        while(n!=0){
            int ld=n%10;
            if(ld!=0 && num%ld==0){
            count++;
            }
            n=n/10;
        }
        return count;
    }
}
