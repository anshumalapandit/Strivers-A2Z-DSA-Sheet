class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=0;
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           int curValue=map.get(ch);
           if(i!=s.length()-1){
             // check ki iska next chota hai
             char next=s.charAt(i+1);
             int nextVal=map.get(next);
            if(curValue>=nextVal){
                // consider + simply add
                ans+=curValue;
            }else{
                // its means cur is chota to -
                ans-=curValue;
            }
           }else{
            ans+=curValue;
           }
        }
        return ans;
    }
}
