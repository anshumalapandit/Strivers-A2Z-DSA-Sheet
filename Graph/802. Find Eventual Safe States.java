class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // first i will make adj list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        //first i will reverse the edges 
        int indeg[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int nbrs:graph[i]){
                adj.get(nbrs).add(i);
                indeg[i]++;
            }
        }
       // plain top sort
       List<Integer> ans=new ArrayList<>();
       // whose indeg ==0 add it to quee
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0){
            q.add(i);
        }
       }
      while(q.size()>0){
        int cur=q.poll();
        ans.add(cur);
        // now reduce its dependency from its nbrs
        for(int nbr:adj.get(cur)){
            indeg[nbr]--;
            if(indeg[nbr]==0){
                q.add(nbr);
            }
        }
      }
      // dont forget to sort the edges
      Collections.sort(ans);
      return ans;
    }
}
