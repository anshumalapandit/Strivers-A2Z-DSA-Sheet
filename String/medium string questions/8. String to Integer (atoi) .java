class Solution {
    public int myAtoi(String s) {
      int i=0;
     s=s.trim(); // it will remove all trailing and leading spaces
      int sign=1; // be default i am considering its positive
      if(s.length()==0){
        return 0;
      }
      if(s.charAt(i)=='-' || s.charAt(i)=='+'){
        sign=s.charAt(i)=='-'?-1:1;
        i++;
      }
      long ans=0;
      int n=s.length();
    
    //   while(s.charAt(i)==' '){
    //     i++; // ignoring whitespaces
    //   }
      while(i<n && Character.isDigit(s.charAt(i))){
        int val=s.charAt(i)-'0';
        ans=ans*10+val;
        if(ans*sign>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ans*sign<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        i++;
      }
    return (int)(ans*sign);
    }
}
