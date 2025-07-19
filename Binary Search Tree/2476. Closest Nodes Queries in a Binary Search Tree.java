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
// optimised approach
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
    public List<Integer> find(int key,List<Integer> sorted){
    int low = 0, high = sorted.size() - 1;
    int floor = -1, ceil = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        int val = sorted.get(mid);

        if (val == key) {
            floor = key;
            ceil = key;
            break;
        } else if (val < key) {
            floor = val;
            low = mid + 1;
        } else {
            ceil = val;
            high = mid - 1;
        }
    }

    return Arrays.asList(floor, ceil);
    }
    public void getInorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        getInorder(root.left,list);
        list.add(root.val);
        getInorder(root.right,list);

    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> sorted=new ArrayList<>();
        getInorder(root,sorted);
        for(int i=0;i<queries.size();i++){
            int val=queries.get(i);
            List<Integer> list=find(val,sorted);
            ans.add(list);
        }
        return ans;
    }
}
