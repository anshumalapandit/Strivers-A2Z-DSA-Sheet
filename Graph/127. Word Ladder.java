class Solution {
    class Pair{
        String word;
        int ht;
        Pair(String word,int ht){
            this.word=word;
            this.ht=ht;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        // now imp step=> remove the starting word from the stack 
        set.remove(beginWord); // if ye word hoga to remove hoga which helps us to not visit this path again
        while(q.size()>0){
            Pair p=q.poll();
            String word=p.word;
            int ht=p.ht;
            // if at any point word == endWord then return steps
            if(word.equals(endWord)){
                // if its is equal to endWord then return steps
                return ht;
            }
            // if not lets find transformation towards endWord
            // word mai jitna letter hai sabke check karenge ek ek letter change karke
            for(int i=0;i<word.length();i++){
               for(char ch='a';ch<='z';ch++){
                // hit= 'h','i','t'
                // convert given string into char Array
                char [] replaced=word.toCharArray();
                replaced[i]=ch; // try replacing current char // ait
                // if this replaced char is in set then good will be removed it from there and put in queue
                // but before checking is in set or not first convert it into string 
                String gotReplaced=new String(replaced);
                if(set.contains(gotReplaced)){
                    // imp very before adding into queue remove it from set so that u cant visit this node again
                    set.remove(gotReplaced);
                    q.add(new Pair(gotReplaced,ht+1));
                }
               }
            }
        }
        return 0;
    }
}
