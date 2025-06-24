class Solution {
    
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>(
           ( (a,b)-> map.get(b)-map.get(a))
        );

        for(char key:map.keySet()){
           pq.add(key);
        }
        StringBuilder ans=new StringBuilder();
        while(pq.size()!=0){
          char cur=pq.poll();
          int freq=map.get(cur);
          while(freq!=0){
          ans.append(cur);
          freq--;
        }
        }
    return ans.toString();
}
}
