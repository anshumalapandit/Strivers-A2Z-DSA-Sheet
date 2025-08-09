class Solution {
    public void dfs(int node,int vis[],List<List<Integer>> adj ){
        // first mark the node as visited
        vis[node]=1;
        // then check for its nbrs
        for(int nbr:adj.get(node)){
            if(vis[nbr]==0){
                dfs(nbr,vis,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // first lets convert this matrix to adj list
     List<List<Integer>> adj=new ArrayList<>();
     int n=isConnected.length;
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     // now whenever u see 1 add that node simple
     for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(isConnected[i][j]!=0){
               adj.get(i).add(j);
            }
        }
     }
     // now call dfs simply
     int vis[]=new int[n];
     int count=0;
     for(int i=0;i<n;i++){
        if(vis[i]==0){
            dfs(i,vis,adj);
            count++;
        }
     }
     return count;   
    }
}
