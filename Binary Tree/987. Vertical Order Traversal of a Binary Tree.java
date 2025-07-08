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
// using bfs
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap: col -> row -> list of values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        bfsTraversal(root, map);  // helper function call

        // Prepare final result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> values : rows.values()) {
                Collections.sort(values); // sort same row,col values
                colList.addAll(values);
            }
            result.add(colList);
        }
        return result;
    }

    // 🔧 BFS Helper Function
    private void bfsTraversal(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // root at row=0, col=0

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, row + 1, col + 1));
        }
    }

    // 📦 Helper class to store node + row + col
    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
