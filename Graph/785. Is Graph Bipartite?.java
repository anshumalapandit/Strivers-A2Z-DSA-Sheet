class Solution {
    public boolean bfs(int node,List<List<Integer>> adj,int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0; // start color 0 blue by default

        while (!q.isEmpty()) {
            int cur = q.poll();
            int clr = color[cur];
            for (int nbr : adj.get(cur)) {
                if (color[nbr] == -1) {
                    // assign opposite color to neighbor
                    color[nbr] = 1 - clr; // smart way of assigning
                    q.add(nbr);
                } else if (color[nbr] == clr) {
                    // neighbor has same color, not bipartite
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        // adj lsit
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        int n=graph.length;
        // Note: always check input format before making adj list
        // graph[i] contains neighbors of i
        for (int i = 0; i < n; i++) {
            for (int nbr : graph[i]) {
                adj.get(i).add(nbr);
            }
        }
       int color[] = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, adj, color)) {
                    return false;  // if any component is not bipartite return immediately
                    // imp when to return what ... here returning false is imp
                }
            }
        }
        return true;  // all components bipartite
    }
}
