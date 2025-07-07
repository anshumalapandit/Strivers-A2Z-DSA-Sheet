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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int max=Integer.MIN_VALUE;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0)); // root , root idx
        while(q.size()>0){
            int size=q.size();
            int minIdx=q.peek().idx; // min idx to starting node ka hi hoga na
            int first=0,last=0; // for first node 
            for(int i=0;i<size;i++){
                int curIdx=q.peek().idx;
                TreeNode curNode=q.peek().node;
                q.poll();
                // if it is first node then store it otherwise leave
                // how u kno it is first idx, bcoz at i==0 pe first hi pair hoga
                if(i==0){
                    first=curIdx;
                }
                // same at last idx last idx present hoga
                if(i==size-1){
                    last=curIdx;
                }
                // why only last first idx? bcoz i need only that. 
                // now add its corresponsind child 
                if(curNode.left!=null){
                    q.add(new Pair(curNode.left,curIdx*2+1));
                }
                if(curNode.right!=null){
                    q.add(new Pair(curNode.right,curIdx*2+2));
                }
            }
            // maximize your width cacculate it
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}
