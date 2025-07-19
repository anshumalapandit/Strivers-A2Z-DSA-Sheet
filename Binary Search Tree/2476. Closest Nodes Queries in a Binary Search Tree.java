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
// gives TLE errror
class Solution {
    public List<Integer> find(TreeNode root,int key){
        if(root==null) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        int min=-1;
        int max=-1;
        while(root!=null){
             if(root.val==key){
             list.add(key);
             list.add(key);
             return list;
           }
           if(key>root.val){
            // go to right but b4 update min
            min=root.val;
            root=root.right;
           }else{
            max=root.val;
            root=root.left;
           }
        }
        list.add(min);
        list.add(max);
        return list;
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            int val=queries.get(i);
            List<Integer> list=find(root,val);
            ans.add(list);
        }
        return ans;
    }
}
