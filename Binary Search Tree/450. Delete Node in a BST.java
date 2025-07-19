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
    public TreeNode find(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
            if(key<root.val){
                root.left=deleteNode(root.left,key);
            }else if(key>root.val){
                root.right=deleteNode(root.right,key);
            }else{
                // yahuu root mil gya jo delete karna hai if its leaf node
                // case 1: leaf node
                if(root.left==null && root.right==null){
                    return null;
                }
                // case 2: one side children, one side null
                if(root.left==null){
                    return root.right;
                }else if(root.right==null){
                    return root.left;
                }
                // no null case 3: deleting node contains both children 
                // finds first inorder successor
                TreeNode successor=find(root.right);
                root.val=successor.val; // replaced
                // now delete successor node not need right we replaced with it 
                root.right=deleteNode(root.right,successor.val); // the very imp step to remember    
        }
        return root;
    }
}
