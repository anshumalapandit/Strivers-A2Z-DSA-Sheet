class Solution {
    class DSU{
        int par[];
        int rank[];
        DSU(int n){
            par=new int[n];
            rank=new int[n];
            // intiliase the parent array with itslef
            for(int i=0;i<n;i++){
                par[i]=i;
            }
        }
        // find how many components
        public int totalComp(){
            int comp=0;
            for(int i=0;i<par.length;i++){
                if(par[i]==i){
                    comp++;
                }
            }
            return comp;
        }
        // find fxn
        public int find(int x){
            if(x==par[x]){
                return x;
            }
            return par[x]=find(par[x]);
        }
        // unionfxn
        public boolean union(int a,int b){
            int parA=find(a);
            int parB=find(b);
            if(parA==parB){
                // both have same parent already connected . means this is extra edge
                return true;
            }
            if(rank[parA]==rank[parB]){
                par[parA]=parB; //a->b update 2 things 1. paremt 2. rank
                rank[parB]++; 
            }else if(rank[parA]<rank[parB]){
                par[parA]=parB;
            }else{
                par[parB]=parA;
            }
            return false;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        // i kno minimum edges reqired to 2 component connect = 1 edge
        DSU dsu=new DSU(n);
        int extraEdges=0;
        for(int edge[]:connections){
            int a=edge[0];
            int b=edge[1];
            // calculating extra edges
            if(dsu.union(a,b)){
              extraEdges++;
            }
        }
        // find how many componnets
        int total=dsu.totalComp();
        int req=total-1;
        if(extraEdges>=req){
            return req;
        }
        return -1;
        
    }
}
