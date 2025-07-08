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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> row -> list of values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colVals = new ArrayList<>();
            for (List<Integer> vals : rows.values()) {
                Collections.sort(vals);
                colVals.addAll(vals);
            }
            result.add(colVals);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col,TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (node == null) return;

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<>());
        map.get(col).get(row).add(node.val);

        dfs(node.left,  row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
