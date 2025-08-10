class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // lets make first adj list
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indeg[]=new int[numCourses];
        for(int pre[]:prerequisites){
            int course=pre[0];
            int preq=pre[1];
            adj.get(preq).add(course);
            indeg[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        // whose indegree 0 i will add all those node into queue
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int ans[]=new int[numCourses];
        int idx=0;
        // now i will process queue 
        while(q.size()>0){
            int cur=q.poll();
            ans[idx]=cur;
            idx++;
            // i  will decrease its dependency 
            for(int nbr:adj.get(cur)){
                indeg[nbr]--;
                if(indeg[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        // if all 0 means there will be cycle ..
        // return empty array
        if(idx==numCourses){
            return ans;
        }
        return new int[]{};
    }
}
