class Solution {
    static long count(int n) {
    // code here
    double edges=n*(n-1)/2;
    double graph=Math.pow(2,edges);
   return (long)graph;
  }
}
