class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static boolean helper(Node root){
        if(root==null) {
            return true; 
        }
        //Leaf nodes have no children There’s nothing to add or check 
        //So the rule doesn’t apply to them
         if(root.left==null && root.right==null){
             return true;
         }
        
        int leftVal=root.left!=null? root.left.data:0;
        int rightVal=root.right!=null? root.right.data:0;
        if (root.data == leftVal + rightVal) {
            // if this node is valid, check for its children
            return helper(root.left) && helper(root.right);
        }
        return false; // false;
    }
    public static int isSumProperty(Node root) {
        // add your code here
        boolean ans= helper(root);
        return ans==true? 1:0;
    }
}
