/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int max[]=new int[1];
        max[0] = Integer.MIN_VALUE; // ⚠️ Important to initialize to handle negative path sum
        helper(root,max);
        return max[0];
    }
    public int helper(TreeNode root,int max[]){
        if(root==null){
            return 0;
        }
        int leftPathSum=helper(root.left,max);
        int rightPathSum=helper(root.right,max);
        //if at any point left/right path sum <0 negative then consider 0
        if(leftPathSum<0){
            leftPathSum=0;
        }
        if(rightPathSum<0){
            rightPathSum=0;
        }
        max[0]=Math.max(max[0],leftPathSum+rightPathSum+root.val);
        return Math.max(leftPathSum,rightPathSum)+root.val; // imp step  take maximum one 
    }
}
