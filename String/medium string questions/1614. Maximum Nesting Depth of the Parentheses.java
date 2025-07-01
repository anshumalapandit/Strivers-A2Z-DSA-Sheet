class Solution {
    public int maxDepth(String s) {
        int recentDepth=0;
        int depth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
            }else if(s.charAt(i)==')'){
                depth--;
            }
            recentDepth=Math.max(recentDepth,depth);
        }
        return recentDepth;
    }
}
