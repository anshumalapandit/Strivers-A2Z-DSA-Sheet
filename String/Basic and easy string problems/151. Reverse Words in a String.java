import java.util.Stack;
class Solution {
    public String reverseWords(String s) {
        String arr[]=s.trim().split("\\s+");
        Stack <String> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            
           stack.push(arr[i]);
        }
        String ans[]=new String[arr.length];
        int j=0;
        while(!stack.isEmpty()){
        ans[j]=stack.pop();
        j++;
        }
        String finalans="";
        for(int k=0;k<ans.length-1;k++){
            finalans+=ans[k]+" ";
        }
        finalans+=ans[ans.length-1];
        return finalans;
    }
}
//T.C is 0(n2) 
