class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        String ans="";
        int ansLen=0;
        // Expand around center approach
        // for odd String
    
        for(int i=0;i<s.length();i++){
          int l=i;
          int r=i;
          while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            int curLen=r-l+1;
            if(curLen>ansLen){
                ans=s.substring(l,r+1);
                 ansLen=curLen;
            }
            l--;
            r++;
          }
        }
        // now for even string palindrome
        for(int i=0;i<s.length();i++){
            int l=i;
            int r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                int curLen=r-l+1;
                if(curLen>ansLen){
                    ans=s.substring(l,r+1);
                     ansLen=curLen;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
