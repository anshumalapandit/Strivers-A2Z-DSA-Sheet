class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            char replaced=t.charAt(i);
            // firstly i will check it it already present in map1 or not
            // if it is not present also its mapping wala not mapped with anyone 
            // then add it in map1 map2
            if(!map1.containsKey(cur) && !map2.containsKey(replaced)){
                map1.put(cur,replaced);
                map2.put(replaced,cur);
            }
            // case 2: if s charact already present in map1 then check its replaced value 
            // if same character is in t then map kardo , t char==s ka replaced value
            if(map1.containsKey(cur)){
                // egg add d-d
                char itsReplacedvalue=map1.get(cur);
                if(itsReplacedvalue!=replaced){
                    return false;
                }
            }
            // case 3 : special case for badc, baba
            if(!map1.containsKey(cur)){
                // its not present then must check ye jisse mapped hora wo kisi or se mapped hoke to nhi baitha
                // if already mapped hai to
                if(map2.containsKey(replaced)){
                   return false;
                }
            }
        }
        return true;
    }
}
