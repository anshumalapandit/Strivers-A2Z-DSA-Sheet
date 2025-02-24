public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count=0;
        for(int i=0;i<A.size();i++){
            int xor=0;
            for(int j=i;j<A.size();i++){
                xor^=A.get(j);
                if(xor==0){
                    count++;
                }
            }
        }
        return count;
    }
}

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
            int x=xor^k;
            if(map.containsKey(x)){
                count+=map.get(x);
            }
            if(map.containsKey(xor)){
                map.put(xor,map.getOrDefault(xor,0)+1);
            }else{
                map.put(xor,1);
            }
        }
        return count;
    }
}
