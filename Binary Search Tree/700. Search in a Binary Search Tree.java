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
T.C=0(H)
class Solution {
    public TreeNode helper(TreeNode root,int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        if(val<root.val){
            return helper(root.left,val);
        }else{
            return helper(root.right,val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root,val);
    }
}
