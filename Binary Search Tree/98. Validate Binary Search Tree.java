// my approach
class Solution {

    public boolean helperLeft(TreeNode root, int max) {
        if (root == null) return true;
        if (root.val >= max) return false;
        return helperLeft(root.left, max) && helperLeft(root.right, max);
    }

    public boolean helperRight(TreeNode root, int min) {
        if (root == null) return true;
        if (root.val <= min) return false;
        return helperRight(root.left, min) && helperRight(root.right, min);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
       // here min max is nothing but current root value
        boolean leftCheck = true;
        boolean rightCheck = true;

        if (root.left != null) {
            leftCheck = root.left.val < root.val &&
                        helperLeft(root.left, root.val) &&
                        isValidBST(root.left);
        }

        if (root.right != null) {
            rightCheck = root.right.val > root.val &&
                         helperRight(root.right, root.val) &&
                         isValidBST(root.right);
        }

        return leftCheck && rightCheck;
    }
}
