/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public boolean getPath(ArrayList<Integer> ans,TreeNode root,int node){
        if(root==null){
            return false;
        }
        // include it in my ans
        ans.add(root.val);
        if(root.val==node){
            // means i reached return lets go back 
            return true;
        }
        // go to left and go to right
        boolean left=getPath(ans,root.left,node);
        boolean right=getPath(ans,root.right,node);
        // if kisi bhi path se mil gya ans to return kardo 
        if(left || right){
            return true;
        }
        // else yaha tak aaya means false hi return hua hoga
        // so remove my last node during backtracking bcoz i am on wrong path 
        
        ans.remove(ans.size()-1); // so whatever i added in last will get removed 
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(A==null){
            return ans;
        }
        getPath(ans,A,B);
        return ans;
    }
}
