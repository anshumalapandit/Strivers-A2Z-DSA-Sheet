// User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length-1;j++){
                int u=edges[i][j];
                int v=edges[i][j+1];
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                //}
            }
        }
        return graph;
    }
}
