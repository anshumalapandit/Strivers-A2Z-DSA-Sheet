class Solution {
    public void helper(List<List<Integer>> adj,int indeg[],int count[]){
        // add all nodes whose indegree is 0
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        // now poll from queue one by one will perform operation
        while(q.size()>0){
            int cur=q.poll();
            count[0]++;
            // check for its nbrs
            for(int nbr:adj.get(cur)){
                // now we taken the current course so its dependency from other courses dec by 1
                indeg[nbr]--;
                if(indeg[nbr]==0){
                    q.add(nbr);
                }
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // First i will convert it into adj list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        // now make edge add it to list
        int indeg[]=new int[numCourses];
        for(int pre[]:prerequisites){
           int src=pre[0];
           int dest=pre[1];
           // here dest is dependent into src
           adj.get(dest).add(src);
           indeg[src]++;
        }
        // lets check first if kisi ka bhi indegree 0 nhi hai means sab depend hai cycle hai
        boolean isZero=false;
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
               isZero=true;
               // means no cycle some chance to get top sort
               break;
            }
        }
        if(isZero==false){
            return false; // no chance any
        }
        int count[]=new int[1];
        helper(adj,indeg,count);
        if(count[0]==numCourses){
            return true; //count == numCourses ka matlab hai ki tumne saare courses successfully process kiye,
//agar koi course chhut gaya to matlab cycle hai.
        }
        return false;
    }
}
