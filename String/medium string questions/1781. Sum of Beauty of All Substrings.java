class Solution {
    public static int findBeauty(String cur) {
       
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cur.length(); i++) {
            map.put(cur.charAt(i), map.getOrDefault(cur.charAt(i), 0) + 1);
        }
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
            if (freq != 0) {
                minFreq = Math.min(minFreq, freq);
            }
        }
        return maxFreq-minFreq;
    }

    public int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j++) {
                String cur = s.substring(i, j + 1);
                int beauty = findBeauty(cur);
                sum += beauty;
            }
        }
        return sum;
    }
}
class Solution {
    public static int getMin(int freq[]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]!=0) // remember 0 is not our least freq 
            min=Math.min(min,freq[i]);
        }
        return min;
    }
    public static int getMax(int freq[]){
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,freq[i]);
        }
        return max;
    }
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int freq[]=new int[26];
            for(int j=i;j<s.length();j++){
                // rem= i have to add char at idx Jth wala not i
                freq[s.charAt(j)-'a']++; 
                int beauty=getMax(freq)-getMin(freq);
                sum+=beauty;
            }
        }
        return sum;
    }
}
