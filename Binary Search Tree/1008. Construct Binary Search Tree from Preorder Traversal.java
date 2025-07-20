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
    public TreeNode helper(TreeNode root,int next){
        if(root==null){
            TreeNode node=new TreeNode(next);
            return node;
        }
        if(next<root.val){
            root.left=helper(root.left,next);
        }else{
            root.right=helper(root.right,next);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]); // root node
        if(preorder.length==1){
            return root;
        }
        for(int i=1;i<preorder.length;i++){
            int nextNode=preorder[i];
            helper(root,nextNode);
        }
        return root;
    }
}
