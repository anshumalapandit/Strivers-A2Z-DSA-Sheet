class Solution {
    public String intToRoman(int num) {
         // Use LinkedHashMap to maintain insertion order
// remember u cant use character here bcoz char store only single char u r storing XC.cm..
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

    StringBuilder sb=new StringBuilder();
    for (String key:map.keySet()){
        // if given no. is > than first smallest no. it then reduced by that
        int firstSmallest=map.get(key);
        if(num>=firstSmallest){
           int times=num/firstSmallest;
           int left=num%firstSmallest;
           while(times!=0){
            sb.append(key);
            times--;
           }
           num=left;
        }
    }
    return sb.toString();

}
}
