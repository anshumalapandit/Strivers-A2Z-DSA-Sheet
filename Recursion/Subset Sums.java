// User function Template for Java//User function Template for
import java.util.ArrayList;
import java.util.Collections;
class Main {
    public static void main(String args[]){
        int arr[]={1,2,1};
        ArrayList<Integer> ans=subsetSums(arr);
        System.out.println(ans);
    }
    public static void helper(int idx,int sum,int n,int arr[],ArrayList<Integer> ans){
        if(idx==n){
            ans.add(sum); // if i reached at the end i will add what i end up with sum
            return;
        }
        // now i have 2 choices either i pick the element or not
        // we have to move further during picking or not picking
        //1. pick and move
        helper(idx+1,sum+arr[idx],n,arr,ans);
        //2. not pick and move
        helper(idx+1,sum,n,arr,ans);
        
    }
    public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        // idx=0, sum=0
        helper(0,0,arr.length,arr,ans);
        Collections.sort(ans);
        return ans;
    }
}
