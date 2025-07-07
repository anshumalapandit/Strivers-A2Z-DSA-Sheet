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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true; // to trag zigzag order
        List<List<Integer>> ans=new ArrayList<>();
        while(q.size()>0){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curNode=q.poll();
                list.add(curNode.val);
                if(curNode.left!=null) q.add(curNode.left);
                if(curNode.right!=null) q.add(curNode.right);
            }
            if(flag){
                // assuminh true=left to right
                 ans.add(list);
            }else{
                // right to left
                Collections.reverse(list);
                ans.add(list);
            }
            flag=!flag; // toggle it
        }
        return ans;
    }
}
