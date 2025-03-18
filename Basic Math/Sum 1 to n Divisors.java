/ User function Template for Java
class Solution {
    public static int helper(int n){
        int Sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                Sum+=i;
            }
        }
        return Sum;
    }
    public static int sumOfDivisors(int n) {
        // code here
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=helper(i);
        }
        return sum;
    }
}
