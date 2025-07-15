/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void findParent(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null){
            return;
        }
        if(root.left!=null){
            // add its child with its parent node
            map.put(root.left,root);
        }
        if(root.right!=null){
            map.put(root.right,root);
        }
        findParent(root.left,map);
        findParent(root.right,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        findParent(root,map);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        q.add(target); // i want to start from target node and will perform bfs
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                visited.add(cur);
                // check kro kya iss current node ka koi parent hai if hai unvisited hai to add back in queue
                // if suppose i reached and distance becomes 0 add kardo direct
                if(k==0){
                ans.add(cur.val);
                }
                if(map.containsKey(cur) && !visited.contains(map.get(cur))){
                    // add its paren into queue=imp
                    q.add(map.get(cur));
                }
                // now add its corresponsing child left right =bfs like
                if(cur.left!=null && visited.contains(cur.left)==false){
                    q.add(cur.left);
                }
                if(cur.right!=null && visited.contains(cur.right)==false){
                    q.add(cur.right);
                }
                if(k<0){
                    break;
                }
            } // pura ek unit complete hone k baad k-- kro
            k--;
        }
        return ans;
    }
}
