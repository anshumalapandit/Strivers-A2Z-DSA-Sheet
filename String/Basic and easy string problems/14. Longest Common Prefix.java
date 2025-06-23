//  brute force:
class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs.length == 0) return "";

        String first = strs[0]; // this is my first string 
        StringBuilder prefix = new StringBuilder();
        // now i will iterate over first string 
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
           // i will take its character 
           // then i will itearte over next strings of array 
            for (int j = 1; j < strs.length; j++) {
                // check character by chacater 
                // if length is short or char mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    // why i>=strs=> to check that uss particular current string k pAAS ith character hai ki nhi
                    // if at any point mismatch is found then i will return immediately
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }
}
// semi optimised
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            int curLen=strs[i].length();
            smallest=Math.min(curLen,smallest);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<smallest;i++){
            char cur=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
             if(strs[j].charAt(i)!=cur){
                 return sb.toString(); // return early as misMatch found
             }
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}
// optimised
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        // now i will only compare first and last word each character
        int idx=0;
        while(idx<first.length()){
            if(first.charAt(idx)==last.charAt(idx)){
                idx++;
            }else{
                break;
            }
        }
        return idx==0? "":first.substring(0,idx);
    }
}
