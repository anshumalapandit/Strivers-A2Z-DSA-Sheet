class Solution {
    public void helper(int[][] image,int sr,int sc,int color,boolean vis[][],int orgColor){
        // base case 
        // when u dont want to change color
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgColor){
            return; // invalid condition 
        }
        // 2 things need to do for every node
        // 1. mark it visited
        vis[sr][sc]=true;
        // 2. change it color
        image[sr][sc]=color;
        //left row will remain same , col will change
        helper(image,sr,sc-1,color,vis,orgColor);
        //right , row will remain same, col will inc by 1
        helper(image,sr,sc+1,color,vis,orgColor);
        //up row will change by 1 , col will remain same
        helper(image,sr-1,sc,color,vis,orgColor);
        //down , row will inc by 1 , col will remain same
        helper(image,sr+1,sc,color,vis,orgColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     boolean vis[][]=new boolean[image.length][image[0].length];
     //dont forget to pass 
     helper(image,sr,sc,color,vis,image[sr][sc]);
     return image;
    }
}
