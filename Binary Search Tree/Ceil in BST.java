// Ceil in BST
class Tree {
    int findCeil(Node root, int key) {
        // code here
        if(root==null){
            return -1;
        }
        if(key==root.data) return key;
        if(key<root.data) {
        int left=findCeil(root.left,key);
        if(left==-1 && key<root.data)
        return root.data;
        else if(left!=-1) // else if part is imp, means its my target and matched value
          return left;
        }
        else {
           return findCeil(root.right,key);
        }
        return -1;
    }
}
