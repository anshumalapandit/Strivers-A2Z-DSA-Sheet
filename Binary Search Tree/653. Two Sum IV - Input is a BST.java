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
    public void getAllNodes(List<Integer> list,TreeNode root){
        if(root==null){
            return ;
        }
        list.add(root.val);
        getAllNodes(list,root.left);
        getAllNodes(list,root.right);
    }
    public boolean performDFS(TreeNode root,List<Integer> list,int k){
        if(root==null){
            return false;
        }
       
        int currentVal=root.val;
        // imp to remember= k-currentVal !=currentVal , bcoz list mai currentVal bhi hai
        // e.g target is 10, if we have only 5 in list then it can be 5+5=10 return true which is wrong
        if(list.contains(k-currentVal) && k - currentVal != currentVal){
            return true;
        }
        return performDFS(root.left,list,k) || performDFS(root.right,list,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        getAllNodes(list,root);
       return performDFS(root,list,k);
    }
}
